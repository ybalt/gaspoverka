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
    private float Result;
    private float MedVal;
    private float SysError;
    private float MedSqDev;
    private float RandError;
    private float RelativeError;

    public float getMedSqDev() {
        return MedSqDev;
    }

    public void setMedSqDev(float MedSqDev) {
        this.MedSqDev = MedSqDev;
    }

    public float getMedVal() {
        return MedVal;
    }

    public void setMedVal(float MedVal) {
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

    public float getRandError() {
        return RandError;
    }

    public void setRandError(float RandError) {
        this.RandError = RandError;
    }

    public float getRelativeError() {
        return RelativeError;
    }

    public void setRelativeError(float RelativeError) {
        this.RelativeError = RelativeError;
    }

    public float getResult() {
        return Result;
    }

    public void setResult(float Result) {
        this.Result = Result;
    }

    public float getSysError() {
        return SysError;
    }

    public void setSysError(float SysError) {
        this.SysError = SysError;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

}
