package gaspoverka.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
}
    
}
