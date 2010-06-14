package gaspoverka.data.result;

import gaspoverka.data.config.*;

public class Izm {
    
    RoundFactory rf;
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
        return rf.Rounded(CP);
    }

    public void setCP(double CP) {
        this.CP = CP;
    }

    public double getCT() {
        return rf.Rounded(CT);
    }

    public void setCT(double CT) {
        this.CT = CT;
    }

    public double getCV() {
        return rf.Rounded(CV);
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
        return rf.Rounded(RP);
    }

    public void setRP(double RP) {
        this.RP = RP;
    }

    public double getRT() {
        return rf.Rounded(RT);
    }

    public void setRT(double RT) {
        this.RT = RT;
    }

    public double getRV() {
        return rf.Rounded(RV);
    }

    public void setRV(double RV) {
        this.RV = RV;
    }

    public double getCVpr() {
        return rf.Rounded(CVpr);
    }

    public void setCVpr(double CVpr) {
        this.CVpr = CVpr;
    }

    public double getErr() {
        return rf.Rounded(Err);
    }

    public void setErr(double Err) {
        this.Err = Err;
    }

    public double getRVpr() {
        return rf.Rounded(RVpr);
    }

    public void setRVpr(double RVpr) {
        this.RVpr = RVpr;
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

        rf = new RoundFactory();
    }
}
