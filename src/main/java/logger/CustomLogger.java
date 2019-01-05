package logger;

import org.slf4j.Logger;
import org.slf4j.Marker;

import utils.Utils;

import static utils.Utils.INFO;
import static utils.Utils.DEBUG;
import static utils.Utils.WARN;
import static utils.Utils.TRACE;
import static utils.Utils.ERROR;

/**
 * Implementation of custom logger since SCF does not allow apache logger
 * 
 * We will not implement all of it at one time, instead we will implement it as needed
 * 
 * Why not just forward logger output to stdout? 
 * Unfortunately, it is does not working in SCF
 * 
 * @author dongxuny
 *
 */
public class CustomLogger implements Logger {
    private final String name;
    
    public CustomLogger(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public boolean isTraceEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    public void trace(String msg) {
        msg = Utils.getLoggerPrefix(TRACE) + msg;
        System.out.println(msg);
    }

    public void trace(String format, Object arg) {
        format = Utils.getLoggerPrefix(TRACE) + format;
        System.out.println(String.format(format, arg));
    }

    public void trace(String format, Object arg1, Object arg2) {
        format = Utils.getLoggerPrefix(TRACE) + format;
        System.out.println(String.format(format, arg1, arg2));
    }

    public void trace(String format, Object... arguments) {
        format = Utils.getLoggerPrefix(TRACE) + format;
        System.out.println(String.format(format, arguments));
    }

    public void trace(String msg, Throwable t) {
        msg = Utils.getLoggerPrefix(TRACE) + msg;
        System.out.println(String.format(msg, t));
    }

    public boolean isTraceEnabled(Marker marker) {
        // TODO Auto-generated method stub
        return false;
    }

    public void trace(Marker marker, String msg) {
        // TODO Auto-generated method stub
        
    }

    public void trace(Marker marker, String format, Object arg) {
        // TODO Auto-generated method stub
        
    }

    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    public void trace(Marker marker, String format, Object... argArray) {
        // TODO Auto-generated method stub
        
    }

    public void trace(Marker marker, String msg, Throwable t) {
        // TODO Auto-generated method stub
        
    }

    public boolean isDebugEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    public void debug(String msg) {
        msg = Utils.getLoggerPrefix(DEBUG) + msg;
        System.out.println(msg);
    }

    public void debug(String format, Object arg) {
        format = Utils.getLoggerPrefix(DEBUG) + format;
        System.out.println(String.format(format, arg));
    }

    public void debug(String format, Object arg1, Object arg2) {
        format = Utils.getLoggerPrefix(DEBUG) + format;
        System.out.println(String.format(format, arg1, arg2));
    }

    public void debug(String format, Object... arguments) {
        format = Utils.getLoggerPrefix(DEBUG) + format;
        System.out.println(String.format(format, arguments));
    }

    public void debug(String msg, Throwable t) {
        msg = Utils.getLoggerPrefix(DEBUG) + msg;
        System.out.println(String.format(msg, t));
    }

    public boolean isDebugEnabled(Marker marker) {
        // TODO Auto-generated method stub
        return false;
    }

    public void debug(Marker marker, String msg) {
        // TODO Auto-generated method stub
        
    }

    public void debug(Marker marker, String format, Object arg) {
        // TODO Auto-generated method stub
        
    }

    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    public void debug(Marker marker, String format, Object... arguments) {
        // TODO Auto-generated method stub
        
    }

    public void debug(Marker marker, String msg, Throwable t) {
        // TODO Auto-generated method stub
        
    }

    public boolean isInfoEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    public void info(String msg) {
        msg = Utils.getLoggerPrefix(INFO) + msg;
        System.out.println(msg);
    }

    public void info(String format, Object arg) {
        format = Utils.getLoggerPrefix(INFO) + format;
        System.out.println(String.format(format, arg));
    }

    public void info(String format, Object arg1, Object arg2) {
        format = Utils.getLoggerPrefix(INFO) + format;
        System.out.println(String.format(format, arg1, arg2));
    }

    public void info(String format, Object... arguments) {
        format = Utils.getLoggerPrefix(INFO) + format;
        System.out.println(String.format(format, arguments));
    }

    public void info(String msg, Throwable t) {
        msg = Utils.getLoggerPrefix(INFO) + msg;
        System.out.println(String.format(msg, t));
    }

    public boolean isInfoEnabled(Marker marker) {
        // TODO Auto-generated method stub
        return false;
    }

    public void info(Marker marker, String msg) {
        // TODO Auto-generated method stub
        
    }

    public void info(Marker marker, String format, Object arg) {
        // TODO Auto-generated method stub
        
    }

    public void info(Marker marker, String format, Object arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    public void info(Marker marker, String format, Object... arguments) {
        // TODO Auto-generated method stub
        
    }

    public void info(Marker marker, String msg, Throwable t) {
        // TODO Auto-generated method stub
        
    }

    public boolean isWarnEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    public void warn(String msg) {
        msg = Utils.getLoggerPrefix(WARN) + msg;
        System.out.println(msg);
    }

    public void warn(String format, Object arg) {
        format = Utils.getLoggerPrefix(WARN) + format;
        System.out.println(String.format(format, arg));
    }

    public void warn(String format, Object... arguments) {
        format = Utils.getLoggerPrefix(WARN) + format;
        System.out.println(String.format(format, arguments));
    }

    public void warn(String format, Object arg1, Object arg2) {
        format = Utils.getLoggerPrefix(WARN) + format;
        System.out.println(String.format(format, arg1, arg2));
    }

    public void warn(String msg, Throwable t) {
        msg = Utils.getLoggerPrefix(WARN) + msg;
        System.out.println(String.format(msg, t));
    }

    public boolean isWarnEnabled(Marker marker) {
        // TODO Auto-generated method stub
        return false;
    }

    public void warn(Marker marker, String msg) {
        // TODO Auto-generated method stub
        
    }

    public void warn(Marker marker, String format, Object arg) {
        // TODO Auto-generated method stub
        
    }

    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    public void warn(Marker marker, String format, Object... arguments) {
        // TODO Auto-generated method stub
        
    }

    public void warn(Marker marker, String msg, Throwable t) {
        // TODO Auto-generated method stub
        
    }

    public boolean isErrorEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    public void error(String msg) {
        msg = Utils.getLoggerPrefix(ERROR) + msg;
        System.out.println(msg);
    }

    public void error(String format, Object arg) {
        format = Utils.getLoggerPrefix(ERROR) + format;
        System.out.println(String.format(format, arg));
    }

    public void error(String format, Object arg1, Object arg2) {
        format = Utils.getLoggerPrefix(ERROR) + format;
        System.out.println(String.format(format, arg1, arg2));
    }

    public void error(String format, Object... arguments) {
        format = Utils.getLoggerPrefix(ERROR) + format;
        System.out.println(String.format(format, arguments));
    }

    public void error(String msg, Throwable t) {
        msg = Utils.getLoggerPrefix(ERROR) + msg;
        System.out.println(String.format(msg, t));
    }

    public boolean isErrorEnabled(Marker marker) {
        // TODO Auto-generated method stub
        return false;
    }

    public void error(Marker marker, String msg) {
        // TODO Auto-generated method stub
        
    }

    public void error(Marker marker, String format, Object arg) {
        // TODO Auto-generated method stub
        
    }

    public void error(Marker marker, String format, Object arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    public void error(Marker marker, String format, Object... arguments) {
        // TODO Auto-generated method stub
        
    }

    public void error(Marker marker, String msg, Throwable t) {
        // TODO Auto-generated method stub
        
    }

}
