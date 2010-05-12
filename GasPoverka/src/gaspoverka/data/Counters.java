package gaspoverka.data;

import gaspoverka.db.*;
import java.util.*;

public class Counters {

    private String Type;
    private int Channel;
    private double UD;
    private double PL;
    private double IC;
    private CountersKP kp;
    private MeasureRange mr;
    private CountersDB db;

    public Counters() {
        db = new gaspoverka.db.CountersDB(this);
        kp = new CountersKP();
        mr = new MeasureRange();
    }

    public void save() {
        db.save();
    }

    public void load(String type) {
        db.load(type);
    }

    public void delete(String type) {
        db.delete(type);
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

    public double getIC() {
        return IC;
    }

    public void setIC(double IC) {
        this.IC = IC;
    }

    public double getPL() {
        return PL;
    }

    public void setPL(double PL) {
        this.PL = PL;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public double getUD() {
        return UD;
    }

    public void setUD(double UD) {
        this.UD = UD;
    }

    public CountersDB getDb() {
        return db;
    }

    public void setDb(CountersDB db) {
        this.db = db;
    }

    public CountersKP getKP() {
        return kp;
    }

    public MeasureRange getMR() {
        return mr;
    }
}
