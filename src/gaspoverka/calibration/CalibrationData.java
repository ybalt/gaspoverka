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
    private Vector<Double> data;
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
        return MSQR;
    }

    public double getMedium() {
        return Medium;
    }

    public double getRelError() {
        return RelError;
    }

    public double getSysError() {
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
        return RandError;
    }

    public void setResult(double result, int i) {
        data.set(i, result);
        //set();
    }

    public void setValue(double value) {
        this.Value = value;
    }

    // </editor-fold>
    // calculate data
    public void add(int j) {
        for (int i = 0; i < j; i++) {
            data.add(new Double(0));
        }
    }

    public void set() {
        Medium = 0;
        SysError = 0;
        MSQR = 0;
        RandError = 0;
        RelError = 0;

        double median = 0;
        double sum = 0;
        double kSt = 0;

        try {
        if (data.size() >= 0 && data.size() <= 15) {
            kSt = Student[data.size()];
        } else kSt = 2.094;

        for (int i = 0; i < data.size(); i++) {
            median = median + getDataResult(i);
        }

        Medium = median / data.size();
        if (channel == 11
                || channel == 21
                || channel == 31
                || channel == 41) {
            SysError = ((Medium / Value) - 1) * 100;

            for (int i = 0; i < data.size(); i++) {
                sum = sum + ((getDataResult(i) - Medium) * (getDataResult(i) - Medium));
            }
            MSQR = java.lang.Math.sqrt(sum / (data.size() - 1));
            RandError = kSt * (MSQR / Medium) * 100;
            RelError = SysError + RandError;
        }
        if (channel == 12
                || channel == 22
                || channel == 32
                || channel == 42
                || channel == 43
                || channel == 5) {
            SysError = ((Medium + 273.16) / (Value + 273.16) - 1) * 100;
            for (int i = 0; i < data.size(); i++) {
                sum = sum + ((getDataResult(i) - Medium) * (getDataResult(i) - Medium));
            }
            MSQR = java.lang.Math.sqrt(sum / (data.size() - 1));
            RandError = kSt * (MSQR / (Medium + 273.16)) * 100;
            RelError = SysError + RandError;}
        }
        catch (Exception e) {}
        
    }

    public void clear() {
        data = new Vector<Double>();
        this.Medium = 0;
        this.RandError = 0;
        this.RelError = 0;
        this.SysError = 0;
        this.MSQR = 0;
    }
}
