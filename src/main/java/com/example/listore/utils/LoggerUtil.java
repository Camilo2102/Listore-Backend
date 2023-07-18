package com.example.listore.utils;

import com.example.listore.constants.LogConstants;
import com.example.listore.interceptors.LoggerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void petitionLog(String... args) {
        String log = StringUtil.getFromTemplate(LogConstants.LOG_TEMPLATE_PETITION, args);
        logger.info(log);
    }
}
