/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gaspoverka.data;

/**
 *
 * @author bes
 */
public class CountersPov {

    private String Type;
    private String Number;
    private String Ref;
    private String Owner;
    private String Date;
    private int KP;
    private int MeasureNum;
    private double RefValue;
    private double RefPressure;
    private double RefTemp;
    private double RefRValue;
    private double CounterValue;
    private double CounterPressure;
    private double CounterTemp;
    private double CounterRValue;
    private double Error;
    private double ErrorInRange;

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public double getCounterPressure() {
        return CounterPressure;
    }

    public void setCounterPressure(double CounterPressure) {
        this.CounterPressure = CounterPressure;
    }

    public double getCounterRValue() {
        return CounterRValue;
    }

    public void setCounterRValue(double CounterRValue) {
        this.CounterRValue = CounterRValue;
    }

    public double getCounterTemp() {
        return CounterTemp;
    }

    public void setCounterTemp(double CounterTemp) {
        this.CounterTemp = CounterTemp;
    }

    public double getCounterValue() {
        return CounterValue;
    }

    public void setCounterValue(double CounterValue) {
        this.CounterValue = CounterValue;
    }

    public String getCounter() {
        return Number;
    }

    public void setCounter(String Counter) {
        this.Number = Counter;
    }

    public double getError() {
        return Error;
    }

    public void setError(double Error) {
        this.Error = Error;
    }

    public double getErrorInRange() {
        return ErrorInRange;
    }

    public void setErrorInRange(double ErrorInRange) {
        this.ErrorInRange = ErrorInRange;
    }

    public int getKP() {
        return KP;
    }

    public void setKP(int KP) {
        this.KP = KP;
    }

    public int getMeasureNum() {
        return MeasureNum;
    }

    public void setMeasureNum(int MeasureNum) {
        this.MeasureNum = MeasureNum;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

    public String getRef() {
        return Ref;
    }

    public void setRef(String Ref) {
        this.Ref = Ref;
    }

    public double getRefPressure() {
        return RefPressure;
    }

    public void setRefPressure(double RefPressure) {
        this.RefPressure = RefPressure;
    }

    public double getRefRValue() {
        return RefRValue;
    }

    public void setRefRValue(double RefRValue) {
        this.RefRValue = RefRValue;
    }

    public double getRefTemp() {
        return RefTemp;
    }

    public void setRefTemp(double RefTemp) {
        this.RefTemp = RefTemp;
    }

    public double getRefValue() {
        return RefValue;
    }

    public void setRefValue(double RefValue) {
        this.RefValue = RefValue;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
}
