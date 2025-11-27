package com.slotegrator.application.api.authentication.controller;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.slotegrator.application.api.authentication.model.request.AuthenticationRequest;
import com.slotegrator.application.api.authentication.model.response.AuthenticationResponse;
import com.slotegrator.application.api.authentication.service.AuthenticationService;
import com.slotegrator.framework.api.retrofit.RetrofitServiceBuilder;
import java.io.IOException;
import retrofit2.Response;

public class AuthenticationController {

  private final AuthenticationService authenticationService = new RetrofitServiceBuilder().buildService(
      AuthenticationService.class
  );

  public AuthenticationResponse login(String login, String password) {
    Response<AuthenticationResponse> response;
    try {
      response = authenticationService.login(new AuthenticationRequest(login, password)).execute();
    } catch (IOException e) {
      throw new IllegalArgumentException(format("Error during execution: %s", e.getMessage()));
    }
    return response.body();
  }

  public AuthenticationResponse loginWithStatusCodeVerification(String login, String password) {
    Response<AuthenticationResponse> response;
    try {
      response = authenticationService.login(new AuthenticationRequest(login, password)).execute();
    } catch (IOException e) {
      throw new IllegalArgumentException(format("Error during execution: %s", e.getMessage()));
    }
    int expectedResponseStatusCode = 200;
    assertEquals(expectedResponseStatusCode, response.code());
    return response.body();
  }
}
