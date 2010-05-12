package gaspoverka.data;

import gaspoverka.db.*;
import java.util.*;

public class Sensors {

    private String Type;
    private int Channel;
    private String InfoOut;
    private MeasureRange mr;
    private SensorsDB db;

    public Sensors() {
        db = new SensorsDB(this);
        mr = new MeasureRange();
    }

    public void save() {
        db.save();
    }

    public void load(String type) {
        db.load(type);
    }

    public void delete(String type) {

    }
    public String[] getList() {
        Vector v = db.getList();
        String[] str = new String[v.size()];
        for (int i = 0; i < v.size(); i++) {
            str[i] = String.valueOf(v.get(i));
        }
        return str;

    }

    public String getFirst() {
        Vector v = db.getList();
        return String.valueOf(v.get(0));
    }

    public int getChannel() {
        return Channel;
    }

    public void setChannel(int Channel) {
        this.Channel = Channel;
    }

    public String getInfoOut() {
        return InfoOut;
    }

    public void setInfoOut(String InfoOut) {
        this.InfoOut = InfoOut;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public MeasureRange getMR() {
        return mr;
    }
}
