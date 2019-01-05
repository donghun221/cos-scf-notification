package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static final String SPACE = " ";
    private static final String LBRACE = "[";
    private static final String RBRACE = "]";
    private static final String COLUMN = ":";
    private static final String DASH = "-";

    public static final String INFO = "INFO";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";
    public static final String TRACE = "TRACE";
    public static final String DEBUG = "DEBUG";
    
    /**
     * Formatting as bellow:
     * 
     * 2019-01-04 22:43:35:140 INFO [main] event.PutNotification:39
     * 
     * @param level Logging level
     * @return Return the formatted logging prefix
     */
    public static String getLoggerPrefix(String level) {
        return getTimestamp() +
                SPACE +
                level +
                SPACE +
                LBRACE + getThreadName() + RBRACE +
                SPACE + 
                getClassName() + 
                COLUMN +
                getLineNumber() + 
                SPACE + 
                DASH + 
                SPACE;
    }
    
    /**
     * @return Return the caller stack
     */
    public static String getClassName() {
        return Thread.currentThread().getStackTrace()[4].getClassName();
    }
    
    /**
     * @return Return the caller stack line number
     */
    public static String getLineNumber() {
        return Thread.currentThread().getStackTrace()[4].getLineNumber() + "";
    }
    
    /**
     * @return Return the timestamp
     */
    public static String getTimestamp() {
        long millis = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        
        Date date = new Date(millis);
        return formatter.format(date);
    }
    
    /**
     * @return Return the current thead name
     */
    public static String getThreadName() {
        return Thread.currentThread().getName();
    }
}
