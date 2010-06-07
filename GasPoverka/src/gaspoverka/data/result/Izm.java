package gaspoverka.data.result;

import java.math.BigDecimal;

public class Izm {
    
    int decimalPlace = 4;

    protected int MeasureNum;
    protected double RV;
    protected double RT;
    protected double RP;
    protected double CV;
    protected double CT;
    protected double CP;

    protected double RVpr;
    protected double CVpr;
    protected double Err;

    // <editor-fold defaultstate="collapsed" desc="get&set">
    public double getCP() {
        return Rounded(CP);
    }

    public void setCP(double CP) {
        this.CP = CP;
    }

    public double getCT() {
        return Rounded(CT);
    }

    public void setCT(double CT) {
        this.CT = CT;
    }

    public double getCV() {
        return Rounded(CV);
    }

    public void setCV(double CV) {
        this.CV = CV;
    }

    public int getMeasureNum() {
        return MeasureNum;
    }

    public void setMeasureNum(int MeasureNum) {
        this.MeasureNum = MeasureNum;
    }

    public double getRP() {
        return Rounded(RP);
    }

    public void setRP(double RP) {
        this.RP = RP;
    }

    public double getRT() {
        return Rounded(RT);
    }

    public void setRT(double RT) {
        this.RT = RT;
    }

    public double getRV() {
        return Rounded(RV);
    }

    public void setRV(double RV) {
        this.RV = RV;
    }

    public double getCVpr() {
        return Rounded(CVpr);
    }

    public void setCVpr(double CVpr) {
        this.CVpr = CVpr;
    }

    public double getErr() {
        return Rounded(Err);
    }

    public void setErr(double Err) {
        this.Err = Err;
    }

    public double getRVpr() {
        return Rounded(RVpr);
    }

    public void setRVpr(double RVpr) {
        this.RVpr = RVpr;
    }

    public double Rounded(double d) {
        try {
            BigDecimal k = new BigDecimal(d);
            k = k.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
            return k.doubleValue();
        } catch (Exception e) {
            return 0;
        }
    }

    // </editor-fold>

    public Izm() {
        this.MeasureNum = 0;
        this.CV = 0;
        this.RV = 0;

        this.RP = 0;
        this.RT = 0;

        this.CP = 0;
        this.CT = 0;
        
        this.RVpr = 0;
        this.CVpr = 0;
        this.Err = 0;
    }
}
