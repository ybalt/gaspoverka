package gaspoverka.data;

import gaspoverka.db.*;
import java.util.*;

public class Reference {

    private String Type;
    private int Channel;
    private float UD;
    private float PL;
    private float IC;
    private float MIC;
    private ReferenceDB db;
    private MeasureRange mr;

    public Reference() {
        db = new ReferenceDB(this);
        mr = new MeasureRange();
    }

    public void save() {
        db.save();
    }

    public void load(String type) {
        db.load(type);
    }
    
    public void delete(String type)
    {
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

    public float getIC() {
        return IC;
    }

    public void setIC(float IC) {
        this.IC = IC;
    }

    public float getMIC() {
        return MIC;
    }

    public void setMIC(float MIC) {
        this.MIC = MIC;
    }

    public float getPL() {
        return PL;
    }

    public void setPL(float PL) {
        this.PL = PL;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public float getUD() {
        return UD;
    }

    public void setUD(float UD) {
        this.UD = UD;
    }

    public MeasureRange getMR() {
        return mr;
    }

    
    

    
    

    

    
}
