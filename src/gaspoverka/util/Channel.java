package gaspoverka.util;

import gaspoverka.calibration.Calibration;
import java.lang.Math.*;

public class Channel {

    private int channel;
    public int adress[];//
    double rawResults[];
    Config config = Config.getInstance();
    private Calibration calData;
    RoundFactory rf = RoundFactory.getInstance();

    // <editor-fold defaultstate="collapsed" desc="get&set">
    public int[] getAdress() {
        try {
            if (this.channel != 0 && config != null) {
                String module = config.getConfig().getProperty(String.valueOf(this.channel), "0");
                this.adress[0] = Integer.parseInt(module.substring(0, 1));
                this.adress[1] = Integer.parseInt(module.substring(2, 3));
            } else {
                this.adress[0] = 0;
                this.adress[1] = 0;
            }
        } catch (Exception e) {
            this.adress[0] = 0;
            this.adress[1] = 0;
        }
        return this.adress;
    }

    public double[] getRawResults() {
        return rawResults;
    }

    public void setRawResults(double value, int i) {
        this.rawResults[i] = value;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
        getAdress();
        if (config != null) {
            calData = new Calibration(channel);
            calData.loadCalibrationData();
        }
    }

    public Calibration getCalData() {
        return calData;
    }

    public void setCalData(Calibration calData) {
        this.calData = calData;
    }
    // </editor-fold>

    public Channel(int channel) {
        rawResults = new double[50000];
        this.channel = channel;
        this.adress = new int[2];
        calData = new Calibration(channel);
        calData.loadCalibrationData();
    }

    private double result(final double rawResult) {
        double result = 0;
        //Pressure
        if (this.channel == 11
                || this.channel == 21
                || this.channel == 31
                || this.channel == 41) {
            if (rawResult >= 4 && rawResult <= 20) {
                result = ((rawResult - 4) / 16) * 105;
            } else {
                result = 0;
            }
        }
        //Temperature
        if (this.channel == 12
                || this.channel == 22
                || this.channel == 32
                || this.channel == 42
                || this.channel == 5
                || this.channel == 43) {
            result = rawResult;
            if (rawResult >= 4 && rawResult <= 20) {
                result = (rawResult - 4) / 0.32;
            } else {
                result = 0;
            }
        }
        if (this.channel == 1
                || this.channel == 2
                || this.channel == 3
                || this.channel == 4) {
            result = rawResult;
        }
        return result;
    }

    public double getResult(final double rawResult, boolean calibrated) {
        double result = 0;
        result = result(rawResult);
        if (calibrated) {
            return rf.Rounded(calData.getCalibrated(result));
        } else {
            return rf.Rounded(result);
        }
    }

    public double getResult(boolean calibrated) {
        double result = 0;
        result = result(rawResults[0]);
        if (calibrated) {
            return rf.Rounded(calData.getCalibrated(result));
        } else {
            return rf.Rounded(result);
        }
    }

    public double getResult(boolean calibrated, int i) {
        double result = 0;
        if (i < 0) {
            result = result(rawResults[0]);
        } else {
            result = result(rawResults[i]);
        }
        if (calibrated) {
            return rf.Rounded(calData.getCalibrated(result));
        } else {
            return rf.Rounded(result);
        }
    }

    public double getAO(double g) {
        double go = 0;

        go = calData.getA0Points()[0] * (1 / (g * g))
                + calData.getA0Points()[1] * (1 / g)
                + calData.getA0Points()[2]
                + calData.getA0Points()[3] * g
                + (calData.getA0Points()[4] * g * g);
        /*
        if (this.channel == 3) { //250
        go = -756048.71*(1/(g*g)) +
        54658.18*(1/g)+
        25982.01 +
        4.19468*g +
        (-0.007254*g*g);
        }

        if (this.channel == 2) { //25
        go = 118092.367*(1/(g*g)) +
        (-49218.029*(1/g))+
        (51005.723) +
        (-361.691*g) +
        (7.062*g*g);
        }

        if (this.channel == 1) { //5
        go = 190.661*(1/(g*g)) +
        (-667.154*(1/g))+
        (107222.628) +
        (187.416*g) +
        (-45.512*g*g);
        }*/

        return go;
    }
}
