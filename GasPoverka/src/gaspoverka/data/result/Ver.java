package gaspoverka.data.result;

import java.util.Vector;

public class Ver {

    double Value;
    double Medium;
    double SysError;
    double MSQR;
    double RandError;
    double RelError;
    private Vector<calculator> data;

    private class calculator {

        private int Number;
        private double Result;

        public int getNumber() {
            return Number;
        }

        public void setNumber(int Number) {
            this.Number = Number;
        }

        public double getResult() {
            return Result;
        }

        public void setResult(double Result) {
            this.Result = Result;
        }

        public calculator(int num) {
            this.setNumber(num);
            this.setResult(0);
        }
    }

    public Ver() {
        Value = 0;
        Medium = 0;
        SysError = 0;
        MSQR = 0;
        RandError = 0;
        RelError = 0;
        data = new Vector<calculator>();
    }

    // <editor-fold defaultstate="collapsed" desc="get&set">
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

    public int getDataNum(int i) {
        return data.get(i).getNumber();
    }
    public double getDataRes(int i) {
        return data.get(i).getResult();
    }
    public int getDataCount() {
        return data.size();
    }
    public double getRandError() {
        return RandError;
    }

    public void setDataResult(double result, int i) {
        data.get(i).setResult(result);
    }
    public void setValue(double value) {
        this.Value = value;
    }

    // </editor-fold>

    public void set() {
        Medium = 0;
        SysError = 0;
        MSQR = 0;
        RandError = 0;
        RelError = 0;

        double median = 0;
        double sum = 0;
        double Student = 2.094;

        for (int i = 0; i < data.size(); i++) {
            calculator A = data.get(i);
            median = median + A.getResult();
        }

        Medium = median / data.size();

        SysError = ((Medium / Value) - 1) * 100;

        for (int i = 0; i < data.size(); i++) {
            calculator A = data.get(i);
            sum = sum + ((A.getResult() - Medium) * (A.getResult() - Medium));
        }
        MSQR = java.lang.Math.sqrt(sum / (data.size() - 1));
        RandError = Student * (MSQR / Medium) * 100;
        RelError = SysError + RandError;
    }

    public void add() {
        int i;
        if (data.size() == 0) {
            i = 0;
        } else {
            i = data.lastElement().getNumber();
        }
        data.add(new calculator(i));
    }

    public void clear() {
        data.clear();
    }
}
