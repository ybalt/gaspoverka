package gaspoverka.data.result;

public class Calculation {


    protected int Channel;
    protected String Type;
    protected String DevNum;
    protected String Owner;
    protected int KP;
    protected int MeasureNum;
    protected double ControlValue;
    protected double MeasuredValue;

    // <editor-fold defaultstate="collapsed" desc="get&set">
    public double getMeasuredValue() {
        return MeasuredValue;
    }

    public void setMeasuredValue(double MeasuredValue) {
        this.MeasuredValue = MeasuredValue;
    }

    public double getControlValue() {
        return ControlValue;
    }

    public void setControlValue(double ControlValue) {
        this.ControlValue = ControlValue;
    }

    public int getMeasureNum() {
        return MeasureNum;
    }

    public void setMeasureNum(int MeasureNum) {
        this.MeasureNum = MeasureNum;
    }

    public int getKP() {
        return KP;
    }

    public void setKP(int KP) {
        this.KP = KP;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

    public String getDevNum() {
        return DevNum;
    }

    public void setDevNum(String DevNum) {
        this.DevNum = DevNum;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getChannel() {
        return Channel;
    }

    public void setChannel(int Channel) {
        this.Channel = Channel;
    }// </editor-fold>

    public Calculation() {
        this.Channel = 0;
        this.Type = "";
        this.DevNum = "";
        this.Owner = "";
        this.KP = 0;
        this.MeasureNum = 0;
        this.ControlValue = 0;
        this.MeasuredValue = 0;
    }

}
