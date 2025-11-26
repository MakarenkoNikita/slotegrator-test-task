package com.slotegrator.framework.waiter;

import static java.lang.Thread.sleep;

public class Waiter {

  private Waiter() {
  }

  public static void waitSeconds(long seconds) {
    try {
      sleep(seconds * 1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
