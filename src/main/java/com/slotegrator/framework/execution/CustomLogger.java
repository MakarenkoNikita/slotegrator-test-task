package com.slotegrator.framework.execution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLogger {

  private static final String DEFAULT_LOG_NAME = "Logger";
  private static final Logger log = LogManager.getLogger(DEFAULT_LOG_NAME);

  private CustomLogger() {
  }

  public static Logger getLogger() {
    return log;
  }
}
