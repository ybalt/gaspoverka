/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaspoverka.data;

/**
 *
 * @author bes
 */
public class EvalError {
    private String Type;
    private int Point;
    private int Number;
    private double Result;
    private double MedVal;
    private double SysError;
    private double MedSqDev;
    private double RandError;
    private double RelativeError;

    public double getMedSqDev() {
        return MedSqDev;
    }

    public void setMedSqDev(double MedSqDev) {
        this.MedSqDev = MedSqDev;
    }

    public double getMedVal() {
        return MedVal;
    }

    public void setMedVal(double MedVal) {
        this.MedVal = MedVal;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int Point) {
        this.Point = Point;
    }

    public double getRandError() {
        return RandError;
    }

    public void setRandError(double RandError) {
        this.RandError = RandError;
    }

    public double getRelativeError() {
        return RelativeError;
    }

    public void setRelativeError(double RelativeError) {
        this.RelativeError = RelativeError;
    }

    public double getResult() {
        return Result;
    }

    public void setResult(double Result) {
        this.Result = Result;
    }

    public double getSysError() {
        return SysError;
    }

    public void setSysError(double SysError) {
        this.SysError = SysError;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

}
