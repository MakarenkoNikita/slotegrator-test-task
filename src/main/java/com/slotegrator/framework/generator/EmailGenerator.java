package com.slotegrator.framework.generator;

import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class EmailGenerator {

  private EmailGenerator() {
  }

  public static String generateRandomEmail() {
    return format("%s@gmail.com", randomAlphanumeric(15));
  }
}
