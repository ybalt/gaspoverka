package gaspoverka.data;

import java.util.*;

public class MeasureRange {

    private String Type;
    private int[] Number;
    private float[] MRL;
    private float[] MRH;
    private float[] Error;
    private int MRNUM;

    public MeasureRange() {
    }

    public Vector getTable() {
        Vector vector = new Vector();
        for (int i = 1; i <= MRNUM; i++) {
            Vector row = new Vector();
            row.add(this.getMRH(i));
            row.add(this.getMRL(i));
            row.add(this.getError(i));
            vector.add(row);
        }
        return vector;
    }

    public int getNum() {
        return this.MRNUM;
    }

    public void setNum(int num) {
        this.MRNUM = num;
        Number = new int[num];
        MRL = new float[num];
        MRH = new float[num];
        Error = new float[num];
    }

    public void setMR(int i, int Number, float MRH, float MRL, float Error) {
        if (i < getNum()) {
            setNumber(i, Number);
            setMRH(i, MRH);
            setMRL(i, MRL);
            setError(i, Error);
        }
    }

    public float getError(int i) {
        return Error[i];
    }

    public void setError(int i, float Error) {
        this.Error[i] = Error;
    }

    public float getMRH(int i) {
        return MRH[i];
    }

    public void setMRH(int i, float MRH) {
        this.MRH[i] = MRH;
    }

    public float getMRL(int i) {
        return MRL[i];
    }

    public void setMRL(int i, float MRL) {
        this.MRL[i] = MRL;
    }

    public int getNumber(int i) {
        return Number[i];
    }

    public void setNumber(int i, int Number) {
        this.Number[i] = Number;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
}
