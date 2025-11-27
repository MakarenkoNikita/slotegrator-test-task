package com.slotegrator.application.service.api.login;

import static com.slotegrator.framework.context.dynamic.DynamicContext.cookieSession;
import static com.slotegrator.framework.execution.CustomLogger.getLogger;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.slotegrator.application.api.authentication.controller.AuthenticationController;
import com.slotegrator.application.api.authentication.model.response.AuthenticationResponse;
import org.apache.logging.log4j.Logger;

public class LoginApiOperations {

  private final Logger log = getLogger();

  public void loginAndUpdateAccessToken(String login, String password) {
    log.info("[Step] Login with [{}] user and update access_token", login);
    AuthenticationResponse response = new AuthenticationController().login(login, password);
    cookieSession.setAccessToken(response.accessToken());
  }

  public void loginAndVerifyResponseValue(String login, String password) {
    log.info("[Step] Login with [{}] user", login);
    AuthenticationResponse response = new AuthenticationController().loginWithStatusCodeVerification(login, password);
    assertNotNull(response.accessToken(), "User access token is null");
  }
}
