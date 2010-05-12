package gaspoverka.data;

import java.util.*;

public class MeasureRange {

    private String Type;
    private int[] Number;
    private double[] MRL;
    private double[] MRH;
    private double[] Error;
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
        MRL = new double[num];
        MRH = new double[num];
        Error = new double[num];
    }

    public void setMR(int i, int Number, double MRH, double MRL, double Error) {
        if (i < getNum()) {
            setNumber(i, Number);
            setMRH(i, MRH);
            setMRL(i, MRL);
            setError(i, Error);
        }
    }

    public double getError(int i) {
        return Error[i];
    }

    public void setError(int i, double Error) {
        this.Error[i] = Error;
    }

    public double getMRH(int i) {
        return MRH[i];
    }

    public void setMRH(int i, double MRH) {
        this.MRH[i] = MRH;
    }

    public double getMRL(int i) {
        return MRL[i];
    }

    public void setMRL(int i, double MRL) {
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
