package com.slotegrator.framework.execution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLogger {

  private static final String DEFAULT_LOG_NAME = "Logger";
  private static final ThreadLocal<Logger> log = new ThreadLocal<>();

  private CustomLogger() {
  }

  public static Logger getLogger() {
    if (log.get() == null) {
      log.set(LogManager.getLogger(DEFAULT_LOG_NAME));
    }
    return log.get();
  }
}
