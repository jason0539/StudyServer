package com.daoming.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Hashtable;

public class LogUtils {
    private static Log log = LogFactory.getLog(LogUtils.class);
    private static Hashtable cachedLog = new Hashtable();

    public static final void d(String msg) {
        if (log.isDebugEnabled()) {
            String traceClass = getTraceClass();
            if (cachedLog.get(traceClass) != null) {
                Log log = (Log) cachedLog.get(traceClass);
                log.debug(msg);
            } else {
                Log log = LogFactory.getLog(traceClass);
                log.debug(msg);
                cachedLog.put(traceClass, log);
            }
        }
    }

    private static String getTraceClass() {
        StackTraceElement caller = new Throwable().fillInStackTrace().getStackTrace()[2];
        String className = new StringBuilder().append(caller.getClassName()).toString();
//        return className.substring(className.lastIndexOf(".") + 1);
        return className;
    }

}
