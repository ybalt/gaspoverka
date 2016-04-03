package gaspoverka.calibration;

import java.util.Vector;

public class CalibrationData {

    double Value;
    double Medium;
    double SysError;
    double MSQR;
    double RandError;
    double RelError;
    final static double Student[] = {0, 0, 12.7, 4.3, 3.2, 2.8, 2.6, 2.4, 2.4, 2.3, 2.3, 2.1, 2.1, 2.0, 2.0};
    private final Vector<Double> data;
    int channel;

    public CalibrationData() {
        Value = 0;
        Medium = 0;
        SysError = 0;
        MSQR = 0;
        RandError = 0;
        RelError = 0;
        data = new Vector<Double>();
    }

    // <editor-fold defaultstate="collapsed" desc="get&set">
    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public double getMSQR() {
        if (!data.isEmpty()) 
        {
            double sum = 0;
            for (int i = 0; i < data.size(); i++) {
                sum = sum + ((getDataResult(i) - getMedium()) * (getDataResult(i) - getMedium()));
            }
            MSQR = java.lang.Math.sqrt(sum / (data.size() - 1));
        }
        return MSQR;
    }

    public double getMedium() {
            double median = 0;
            for (int i = 0; i < data.size(); i++) {
                median = median + getDataResult(i);
            }
            Medium = median / data.size();

        return Medium;
    }

    public double getRelError() {
        RelError = getSysError() + getRandError();
        return RelError;
    }

    public double getSysError() {

            if (chIsPres()) {
                SysError = ((getMedium() / Value) - 1) * 100;
            }
            if (chIsTemp()) {
                SysError = ((getMedium() + 273.16) / (Value + 273.16) - 1) * 100;
            }

        return SysError;
    }

    public double getValue() {
        return Value;
    }

    public double getDataResult(int i) {
        return data.get(i);
    }

    public int getDataCount() {
        return data.size();
    }

    public double getRandError() {
        if (chIsPres())
            RandError = getkST() * (getMSQR() / getMedium()) * 100;
        if (chIsTemp())
            RandError = getkST() * (getMSQR() / (getMedium() + 273.16)) * 100;
        return RandError;
    }

    public void setResult(double result, int i) {
        data.set(i, result);
    }

    public void setValue(double value) {
        this.Value = value;
    }

    public boolean chIsPres() {
        return channel == 11
                || channel == 21
                || channel == 31
                || channel == 41;
    }

    public boolean chIsTemp() {
        return channel == 12
                || channel == 22
                || channel == 32
                || channel == 42
                || channel == 43
                || channel == 5;
    }

    public double getkST() {
        double kSt;
        if (data.size() >= 0 && data.size() <= 15) {
            kSt = Student[data.size()];
        } else {
            kSt = 2.094;
        }
        return kSt;
    }

    public void add(int j) {
        for (int i = 0; i < j; i++) {
            data.add(new Double(0));
        }
    }

//    public void set() {
//    }

    public void clear() {
        data.clear();
        this.Medium = 0;
        this.RandError = 0;
        this.RelError = 0;
        this.SysError = 0;
        this.MSQR = 0;
    }
}
