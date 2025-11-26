package com.slotegrator.framework.context.constant;

@SuppressWarnings("unused")
public class EnvironmentConfiguration {

  private String host;
  private int connectionSecondTimeout;
  private int readSecondTimeout;
  private int writeSecondTimeout;
  private String login;
  private String password;

  public String getHost() {
    return this.host;
  }

  public String getBaseUrl() {
    return "https://" + this.host;
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

  public String getLogin() {
    return this.login;
  }

  public String getPassword() {
    return this.password;
  }
}
