package com.slotegrator.login;

import static com.slotegrator.framework.context.constant.StaticContext.environmentConfiguration;

import com.slotegrator.application.service.api.login.LoginApiOperations;
import org.junit.jupiter.api.Test;

public class LoginTest {

  @Test
  public void loginTest() {
    new LoginApiOperations().loginAndVerifyResponseValue(
        environmentConfiguration.getLogin(), environmentConfiguration.getPassword()
    );
  }
}
