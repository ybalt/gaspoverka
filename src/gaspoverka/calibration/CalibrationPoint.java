package gaspoverka.calibration;

import gaspoverka.util.RoundFactory;

public class CalibrationPoint {

    RoundFactory rf = RoundFactory.getInstance();
    private int Point;
    private double X;
    private double Y;
    private double YS;
    private double K1, B1, K2, B2;
    String ur1, ur2;

    public CalibrationPoint(int point) {
        this.Point = point;
        this.X = 0;
        this.Y = 0;
        this.YS = 0;
        this.K1 = 0;
        this.K2 = 0;
        this.B1 = 0;
        this.B2 = 0;
    }

    public CalibrationPoint() {
        this.Point = 0;
        this.X = 0;
        this.Y = 0;
        this.YS = 0;
        this.K1 = 0;
        this.K2 = 0;
        this.B1 = 0;
        this.B2 = 0;
        rf = new RoundFactory();
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int Point) {
        this.Point = Point;
    }

    public double getX() {
        return rf.Rounded(X);
    }

    public void setX(double X) {
        this.X = X;
    }

    public double getY() {
        return rf.Rounded(Y);
    }

    public void setY(double Y) {
        this.Y = Y;
    }

    public double getYS() {
        return rf.Rounded(YS);
    }

    public void setYS(double YS) {
        this.YS = YS;
    }

    public double getB1() {
        return rf.Rounded(B1);
    }

    public void setB1(double B1) {
        this.B1 = B1;
    }

    public double getB2() {
        return rf.Rounded(B2);
    }

    public void setB2(double B2) {
        this.B2 = B2;
    }

    public double getK1() {
        if (K1 == 0) {
            return 1;
        } else {
            return rf.Rounded(K1);
        }
    }

    public void setK1(double K1) {
        this.K1 = K1;
    }

    public double getK2() {
        if (K2 == 0) {
            return 1;
        } else {
            return rf.Rounded(K2);
        }
    }

    public void setK2(double K2) {
        this.K2 = K2;
    }

    public String getUr1() {
        return ur1;
    }

    public void setUr1(String ur1) {
        this.ur1 = ur1;
    }

    public String getUr2() {
        return ur2;
    }

    public void setUr2(String ur2) {
        this.ur2 = ur2;
    }

    
    
}
