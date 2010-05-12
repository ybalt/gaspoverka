package gaspoverka.data;

public class CountersKP {
    //private String Type;

    private int[] KP;
    private double[] ValueL;
    private double[] ValueH;
    private double[] Error;
    private int KPNUM;

    public int getNum() {
        return this.KPNUM;
    }

    public CountersKP() {
    }

    public void setNum(int i) {
        this.KPNUM = i;
        this.KP = new int[i];
        this.ValueL = new double[i];
        this.ValueH = new double[i];
        this.Error = new double[i];
    }

    public double getError(int i) {
        return Error[i];
    }

    public void setError(int i, double Error) {
        this.Error[i] = Error;
    }

    public int getKP(int i) {
        return KP[i];
    }

    public void setKP(int i, int KP, double ValueL, double ValueH, double Error) {
        if (i < getNum()) {
            this.setKP(i, KP);
            this.setValueL(i, ValueL);
            this.setValueH(i, ValueH);
            this.setError(i, Error);
        }
    }

    public void setKP(int i, int KP) {
        this.KP[i] = KP;
    }

    public double getValueL(int i) {
        return ValueL[i];
    }

    public void setValueL(int i, double Value) {
        this.ValueL[i] = Value;
    }

    public double getValueH(int i) {
        return ValueH[i];
    }

    public void setValueH(int i, double Value) {
        this.ValueH[i] = Value;
    }

    public void print() {
        for (int i = 0; i < KPNUM; i++) {
            System.out.print(getKP(i));
            System.out.print("-");
            System.out.print(getValueL(i));
            System.out.print("-");
            System.out.print(getValueH(i));
            System.out.print("-");
            System.out.print(getError(i));
            System.out.println();
        }
    }
}
