package gaspoverka.util;

import java.math.BigDecimal;

public class RoundFactory {

   private static RoundFactory _instance = null;

    final static int decimalPlace = 3;
    final static int decimal_method =  BigDecimal.ROUND_HALF_EVEN;

    public RoundFactory() {

    }

    public double Rounded(double d) {
        try {
            BigDecimal k = new BigDecimal(d);
            k = k.setScale(decimalPlace, decimal_method);
            return k.doubleValue();
        } catch (Exception e) {
            return 0;
        }
    }

    public double Rounded(double d, int pres) {
        try {
            BigDecimal k = new BigDecimal(d);
            k = k.setScale(pres, decimal_method);
            return k.doubleValue();
        } catch (Exception e) {
            return 0;
        }
    }

    public synchronized static RoundFactory getInstance() {
        if (_instance == null) {
            _instance = new RoundFactory();
        }
        return _instance;
    }

}
