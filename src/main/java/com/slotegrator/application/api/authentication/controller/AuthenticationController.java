package com.slotegrator.application.api.authentication.controller;

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
    try {
      return authenticationService.login(new AuthenticationRequest(login, password)).execute().body();
    } catch (IOException e) {
      throw new IllegalArgumentException("Response body is null");
    }
  }

  public Response<AuthenticationResponse> loginWithRawBody(String login, String password) {
    try {
      return authenticationService.login(new AuthenticationRequest(login, password)).execute();
    } catch (IOException e) {
      throw new IllegalArgumentException("Response body is null");
    }
  }
}
