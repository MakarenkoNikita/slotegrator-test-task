package com.slotegrator.application.service.api.login;

import static com.slotegrator.framework.context.dynamic.CookieSession.setAccessToken;
import static com.slotegrator.framework.execution.CustomLogger.getLogger;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.slotegrator.application.api.authentication.controller.AuthenticationController;
import com.slotegrator.application.api.authentication.model.response.AuthenticationResponse;
import org.apache.logging.log4j.Logger;
import retrofit2.Response;

public class LoginApiOperations {

  private final Logger log = getLogger();

  public void loginAndUpdateAccessToken(String login, String password) {
    log.info("[Step] Login with [{}] user and update access_token", login);
    AuthenticationResponse response = new AuthenticationController().login(login, password);
    setAccessToken(response.accessToken());
  }

  public void loginAndVerifyResponseValue(String login, String password) {
    log.info("[Step] Login with [{}] user", login);
    int expectedLoginResponseCode = 200;
    Response<AuthenticationResponse> response = new AuthenticationController().loginWithRawBody(login, password);
    assertAll(
        () -> assertEquals(expectedLoginResponseCode, response.code(),
            "Expected and actual response code isn't equals"),
        () -> {
          assert response.body() != null;
          assertNotNull(response.body().accessToken(), "User access token is null");
        }
    );
  }
}
