package com.slotegrator.application.entity.model;

@SuppressWarnings("unused")
public class EnvironmentConfiguration {

  private String host;
  private int connectionSecondTimeout;
  private int readSecondTimeout;
  private int writeSecondTimeout;

  public String getHost() {
    return this.host;
  }

  public int getConnectionSecondTimeout() {
    return connectionSecondTimeout;
  }

  public int getReadSecondTimeout() {
    return readSecondTimeout;
  }

  public int getWriteSecondTimeout() {
    return writeSecondTimeout;
  }
}
