package gaspoverka.data.config;

import java.math.BigDecimal;

public class Point {

    int decimalPlace = 4;
    private int Point;
    private double X;
    private double Y;
    private double YS;
    private double K1, B1, K2, B2;

    public Point(int point) {
        this.Point = point;
        this.X = 0;
        this.Y = 0;
        this.YS = 0;
        this.K1 = 0;
        this.K2 = 0;
        this.B1 = 0;
        this.B2 = 0;
    }

    public Point() {
        this.Point = 0;
        this.X = 0;
        this.Y = 0;
        this.YS = 0;
        this.K1 = 0;
        this.K2 = 0;
        this.B1 = 0;
        this.B2 = 0;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int Point) {
        this.Point = Point;
    }

    public double getX() {
        return Rounded(X);
    }

    public void setX(double X) {
        this.X = X;
    }

    public double getY() {
        return Rounded(Y);
    }

    public void setY(double Y) {
        this.Y = Y;
    }

    public double getYS() {
        return Rounded(YS);
    }

    public void setYS(double YS) {
        this.YS = YS;
    }

    public double getB1() {
        return Rounded(B1);
    }

    public void setB1(double B1) {
        this.B1 = B1;
    }

    public double getB2() {
        return Rounded(B2);
    }

    public void setB2(double B2) {
        this.B2 = B2;
    }

    public double getK1() {
        return Rounded(K1);
    }

    public void setK1(double K1) {
        this.K1 = K1;
    }

    public double getK2() {
        return Rounded(K2);
    }

    public void setK2(double K2) {
        this.K2 = K2;
    }

    public double Rounded(double d) {
        try {
            BigDecimal k = new BigDecimal(d);
            k = k.setScale(decimalPlace, BigDecimal.ROUND_UP);
            return k.doubleValue();
        } catch (Exception e) {
            return 0;
        }
    }
}
