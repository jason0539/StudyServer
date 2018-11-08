package com.daoming.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogUtils {
    private static final Log log = LogFactory.getLog(LogUtils.class);

    public static final void d(String msg) {
        if (log.isDebugEnabled()) {
            log.debug(msg);
        }
    }
}
