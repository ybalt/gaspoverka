package gaspoverka;

import gaspoverka.util.Log;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.hsqldb.jdbc.JDBCDataSource;

public class memDB {

    private static memDB _instance = null;
    public static Log log = Log.getInstance();
    String db_file = ".//db//database";
    String db_mem = "mem:tempdb";
    private Connection filedb;
    private Connection memdb;
    org.hsqldb.jdbc.JDBCDataSource ds_from;
    org.hsqldb.jdbc.JDBCDataSource ds_to;

    public memDB(){
        ds_from = new JDBCDataSource();
        ds_to = new JDBCDataSource();
        try {
//            ds_to.setDatabase("jdbc:hsqldb:" + db_mem + ";hsqldb.sqllog=3;hsqldb.applog=3");
//            to = ds_to.getConnection("sa", "");
//            to.setAutoCommit(false);
            
            ds_from.setDatabase("jdbc:hsqldb:" + db_file + ";hsqldb.write_delay_millis=100");
            filedb = ds_from.getConnection("sa", "");
//            copy(from, to);
//            to.commit();

        } catch (SQLException ex2) {
            log.out(ex2.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Ошибка открытия базы данных");
            System.exit(0);
        }
    }
    
    public void close() throws SQLException {
            filedb.commit();
            filedb.close();
    }

//    private void copy(Connection from, Connection to) {
//        try {
//            String sql_drop = null;
//            String sql_create = null;
//            String sql_select = null;
//            String sql_insert = null;
//            String sql_insert1 = null;
//
//            DatabaseMetaData md;
//            ResultSet tables, columns;
//            md = from.getMetaData();
//            String[] types = {"TABLE"};
//            tables = md.getTables(null, null, "%", types);
//            while (tables.next()) {
//                String tableName = tables.getString(3);
//                columns = md.getColumns(null, null, tableName, null);
//                sql_drop = "DROP TABLE " + tableName;
//                sql_create = "CREATE CACHED TABLE "
//                        + tableName + " (";
//                sql_select = "SELECT ";
//                sql_insert = "INSERT INTO " + tableName + " (";
//                sql_insert1 = "(";
//                int col = 0;
//                while (columns.next()) {
//                    col = col + 1;
//                    String columnName = columns.getString("COLUMN_NAME");
//                    String typeName = columns.getString("TYPE_NAME");
//                    String typeSize = columns.getString("COLUMN_SIZE");
//
//                    sql_create = sql_create
//                            + columnName + " " + typeName;
//                    sql_select = sql_select + columnName;
//                    sql_insert = sql_insert + columnName;
//                    sql_insert1 = sql_insert1 + "?";
//                    if (typeSize != null && typeName.equalsIgnoreCase("VARCHAR")) {
//                        sql_create = sql_create
//                                + "(" + typeSize + ")";
//                    }
//                    if (!columns.isLast()) {
//                        sql_create = sql_create + ",";
//                        sql_select = sql_select + ",";
//                        sql_insert = sql_insert + ",";
//                        sql_insert1 = sql_insert1 + ",";
//                    }
//                }
//                sql_insert1 = sql_insert1 + ")";
//                sql_create = sql_create + ")";
//                sql_select = sql_select + " FROM " + tableName;
//                sql_insert = sql_insert + ") VALUES " + sql_insert1;
//                try {
//                    PreparedStatement drop = to.prepareStatement(sql_drop);
//                    drop.executeUpdate();
//                } catch (Exception ex) {
//                }
//
//                PreparedStatement create = to.prepareStatement(sql_create);
//                int res = create.executeUpdate();
//
//                PreparedStatement get_data = from.prepareStatement(sql_select);
//                ResultSet data = get_data.executeQuery();
//
//                PreparedStatement insert = to.prepareStatement(sql_insert);
//                while (data.next()) {
//                    for (int i = 1; i < col + 1; i++) {
//                        insert.setObject(i, data.getObject(i));
//                    }
//                    insert.execute();
//                }
//                insert.close();
//                get_data.close();
//                create.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Ошибка открытия базы данных");
//            System.exit(0);
//        }
//    }

    public void write() {
        try {
//            copy(to, from);
            Statement s = filedb.createStatement();
            s.execute("SHUTDOWN");
            s.close();
            filedb.close();
            filedb = ds_from.getConnection("sa", "");
        } catch (Exception e) {
            log.out(e.getLocalizedMessage());
        }
    }

    public synchronized static memDB getInstance() {
        if (_instance == null) {
            _instance = new memDB();
        }
        return _instance;
    }

    public Connection connFile() {
        return this.filedb;
    }

    public Connection connMem() {
        return this.filedb;
    }
}
