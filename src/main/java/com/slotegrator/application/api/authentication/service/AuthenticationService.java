package com.slotegrator.application.api.authentication.service;

import com.slotegrator.application.api.authentication.model.request.AuthenticationRequest;
import com.slotegrator.application.api.authentication.model.response.AuthenticationResponse;
import com.slotegrator.framework.api.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticationService extends RetrofitService {

  @POST("/api/tester/login")
  Call<AuthenticationResponse> login(
      @Body AuthenticationRequest authenticationRequest
  );
}
