package gaspoverka.data.result;

import org.hsqldb.jdbc.jdbcDataSource;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Result {

    private String db_name = ".//db//result";
    private Connection conn;
    private long PovNum;
    private String Type;
    private String DevNum;
    private String Owner;
    private int Channel;
    Vector<Izm> data;
    protected double DErr;

    public Result() {
        PovNum = 0;
        Type = "";
        DevNum = "";
        Owner = "";
        Channel = 0;
        data = new Vector<Izm>();
    }

    // <editor-fold defaultstate="collapsed" desc="get&set">
    public int getChannel() {
        return Channel;
    }

    public void setChannel(int Channel) {
        this.Channel = Channel;
    }

    public Vector<Izm> getData() {
        return data;
    }

    public String getDevNum() {
        return DevNum;
    }

    public void setDevNum(String DevNum) {
        this.DevNum = DevNum;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

    public long getPovNum() {
        return PovNum;
    }

    public void setPovNum(long PovNum) {
        this.PovNum = PovNum;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public double getDErr(int num) {
        return 0;
    }

    // </editor-fold>
    
    public void save() {
        int result;

        try {
            connect();
            //del at first
            PreparedStatement delData = conn.prepareStatement("DELETE FROM RESULT "
                    + "WHERE POVNUM=?");

            delData.setLong(1, this.getPovNum());
            result = delData.executeUpdate();
            delData.close();
            //save
            PreparedStatement saveData = conn.prepareStatement("INSERT INTO RESULT "
                    + "(POVNUM, TYPE, DEVNUM, OWNER, CHANNEL, MNUM, RV, CV, RT, RP, CT, CP) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

            if (data.size() != 0) {
                for (int i = 0; i < data.size(); i++) {
                    saveData.setLong(1, this.getPovNum());
                    saveData.setString(2, this.getType());
                    saveData.setString(3, this.getDevNum());
                    saveData.setString(4, this.getOwner());
                    saveData.setInt(5, this.getChannel());
                    saveData.setInt(6, data.get(i).getMeasureNum());
                    saveData.setDouble(7, data.get(i).getRV());
                    saveData.setDouble(8, data.get(i).getRT());
                    saveData.setDouble(9, data.get(i).getRP());
                    saveData.setDouble(10, data.get(i).getCV());
                    saveData.setDouble(11, data.get(i).getCT());
                    saveData.setDouble(12, data.get(i).getCP());
                    result = saveData.executeUpdate();
                    if (result == 0) {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                        return;
                    }
                }
                saveData.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
                fin();
                JOptionPane.showMessageDialog(null, "Ошибка записи - база данных возвращена в исходное состояние");
                return;
            } catch (Exception ej) {
                ej.printStackTrace();
                fin();
                JOptionPane.showMessageDialog(null, "Ошибка записи - состояние базы данных неизвестно. Обартитесь к разработчику");
                return;
            }
        }
        try {
            conn.commit();
            fin();
        } catch (Exception exc) {
            exc.printStackTrace();
            fin();
        }
    }

    public void load(long PovNum) {
    }

    public long getLastPovNum() {
        ResultSet result;

        try {
            connect();
            PreparedStatement loadData = conn.prepareStatement("SELECT "
                    + "POVNUM "
                    + "FROM RESULT "
                    + "ORDER BY POVNUM ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            result = loadData.executeQuery();
            fin();
            result.beforeFirst();
            if (result.next()) {
                result.last();
                return result.getLong(1);
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public void calc() {
        double Vpr, Err;

        for (int i=0;i<data.size();i++)
        {
            Vpr = (293.16*data.get(i).getRV()*data.get(i).getRP())/((273.16-data.get(i).getRT())*0.1013);
            data.get(i).setRVpr(Vpr);

            Vpr = (293.16*data.get(i).getCV()*data.get(i).getCP())/((273.16-data.get(i).getCT())*0.1013);
            data.get(i).setCVpr(Vpr);

            Err = (data.get(i).getRV()-data.get(i).getCV())/((data.get(i).getRV()))*100;
            data.get(i).setErr(Err);

        }

    }

    private void connect() {
        jdbcDataSource dataSource = new jdbcDataSource();
        try {
            dataSource.setDatabase("jdbc:hsqldb:" + db_name);
            conn = dataSource.getConnection("sa", "");
            conn.setAutoCommit(false);
            System.out.println("Connected");
        } catch (SQLException ex2) {
            ex2.printStackTrace();
            JOptionPane.showMessageDialog(null, "Невозможно открыть базу данных по адресу " + dataSource.getDatabase());
            System.exit(1);
        }
    }

    private void fin() {
        try {
            Statement st = conn.createStatement();
            st.execute("SHUTDOWN");
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка закрытия базы данных");

        }

    }
}
