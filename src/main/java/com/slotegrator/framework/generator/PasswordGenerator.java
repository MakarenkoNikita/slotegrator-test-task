package com.slotegrator.framework.generator;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class PasswordGenerator {

  private PasswordGenerator() {
  }

  public static String generateRandomPassword() {
    return randomAlphanumeric(15);
  }
}
