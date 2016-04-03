package gaspoverka.poverka;

import gaspoverka.util.RoundFactory;

public class PoverkaPoint {

    final static int dV=6;
    RoundFactory rf = RoundFactory.getInstance();
    protected int MeasureNum;
    protected double RG;
    protected double RT;
    protected double RP;
    protected double RV;
    protected double CG;
    protected double CT;
    protected double CP;
    protected double CV;

    // <editor-fold defaultstate="collapsed" desc="get&set">
    public int getMeasureNum() {
        return MeasureNum;
    }

    public double getCP() {
        return rf.Rounded(CP);
    }

    public double getCT() {
        return rf.Rounded(CT);
    }

    public double getCG() {
        return rf.Rounded(CG, dV);
    }

    public double getCV() {
        return rf.Rounded(CV, dV);
    }

    public double getRT() {
        return rf.Rounded(RT);
    }

    public double getRP() {
        return rf.Rounded(RP);
    }

    public double getRG() {
        return rf.Rounded(RG, dV);
    }

    public double getRV() {
        return rf.Rounded(RV, dV);
    }

    public void setMeasureNum(int MeasureNum) {
        this.MeasureNum = MeasureNum;
    }

    public void setCP(double CP) {
        this.CP = CP;
    }

    public void setCT(double CT) {
        this.CT = CT;
    }

    public void setCG(double CG) {
        this.CG = CG;
    }

    public void setRP(double RP) {
        this.RP = RP;
    }

    public void setRT(double RT) {
        this.RT = RT;
    }

    public void setRG(double RG) {
        this.RG = RG;
    }

    public void setCV(double CV) {
        this.CV = CV;
    }

    public void setRV(double RV) {
        this.RV = RV;
    }

    public double getErr() {
        double res;
        if (RV != 0) {
            double deltaP = getRP()-getCP();
            double delta = (deltaP*getCV())/(getRP()*getRV())*100;
            res = (((getCV()-getRV())/getRV())*100)-delta;
        } else {
            res = 0;
        }
        return rf.Rounded(res);
    }

    public double getErrT() {
        double res=0, dT=0;
        if (RV != 0) {
            double deltaP = getRP()-getCP();
            double delta = (deltaP*getCV())/(getRP()*getRV())*100;
            res = (((getCV()-getRV())/getRV())*100)-delta;
            dT = (getRV()*(getRT()-getCT()))/(getRV()*(273.15+getCT()))*100;
        } else {
            res = 0;
        }
        return rf.Rounded(res+dT);
    }

    // </editor-fold>

    public PoverkaPoint() {
        this.MeasureNum = 0;
        this.CG = 0;
        this.RG = 0;

        this.RP = 0;
        this.RT = 0;

        this.CP = 0;
        this.CT = 0;

        this.CV = 0;
        this.RV = 0;
    }
}
