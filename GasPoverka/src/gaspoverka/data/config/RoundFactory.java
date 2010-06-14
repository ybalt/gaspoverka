package gaspoverka.data.config;

import java.math.BigDecimal;

public class RoundFactory {
    int decimalPlace = 4;

    public RoundFactory() {

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
