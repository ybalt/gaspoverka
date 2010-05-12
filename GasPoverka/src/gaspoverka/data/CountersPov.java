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
    private float RefValue;
    private float RefPressure;
    private float RefTemp;
    private float RefRValue;
    private float CounterValue;
    private float CounterPressure;
    private float CounterTemp;
    private float CounterRValue;
    private float Error;
    private float ErrorInRange;

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

    public float getCounterPressure() {
        return CounterPressure;
    }

    public void setCounterPressure(float CounterPressure) {
        this.CounterPressure = CounterPressure;
    }

    public float getCounterRValue() {
        return CounterRValue;
    }

    public void setCounterRValue(float CounterRValue) {
        this.CounterRValue = CounterRValue;
    }

    public float getCounterTemp() {
        return CounterTemp;
    }

    public void setCounterTemp(float CounterTemp) {
        this.CounterTemp = CounterTemp;
    }

    public float getCounterValue() {
        return CounterValue;
    }

    public void setCounterValue(float CounterValue) {
        this.CounterValue = CounterValue;
    }

    public String getCounter() {
        return Number;
    }

    public void setCounter(String Counter) {
        this.Number = Counter;
    }

    public float getError() {
        return Error;
    }

    public void setError(float Error) {
        this.Error = Error;
    }

    public float getErrorInRange() {
        return ErrorInRange;
    }

    public void setErrorInRange(float ErrorInRange) {
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

    public float getRefPressure() {
        return RefPressure;
    }

    public void setRefPressure(float RefPressure) {
        this.RefPressure = RefPressure;
    }

    public float getRefRValue() {
        return RefRValue;
    }

    public void setRefRValue(float RefRValue) {
        this.RefRValue = RefRValue;
    }

    public float getRefTemp() {
        return RefTemp;
    }

    public void setRefTemp(float RefTemp) {
        this.RefTemp = RefTemp;
    }

    public float getRefValue() {
        return RefValue;
    }

    public void setRefValue(float RefValue) {
        this.RefValue = RefValue;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
}
