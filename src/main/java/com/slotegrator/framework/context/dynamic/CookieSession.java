package com.slotegrator.framework.context.dynamic;

public class CookieSession {

  private static String accessToken;

  public static String getAccessToken() {
    return accessToken;
  }

  public static void setAccessToken(String token) {
    accessToken = token;
  }
}
