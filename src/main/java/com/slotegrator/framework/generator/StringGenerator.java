package com.slotegrator.framework.generator;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class StringGenerator {

  private StringGenerator() {
  }

  public static String generateRandomString(int length) {
    return randomAlphabetic(length);
  }
}
