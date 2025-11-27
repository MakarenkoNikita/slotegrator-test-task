package com.slotegrator.application.api.players.service;

import static com.slotegrator.framework.api.HttpHeader.AUTHORIZATION;

import com.slotegrator.application.api.players.model.request.CreatePlayerRequest;
import com.slotegrator.application.api.players.model.request.GetOnePlayerRequest;
import com.slotegrator.application.api.players.model.response.PlayerResponse;
import com.slotegrator.framework.api.retrofit.RetrofitService;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PlayersService extends RetrofitService {

  @POST("/api/automationTask/create")
  Call<PlayerResponse> createPlayer(
      @Header(AUTHORIZATION) String authorization,
      @Body CreatePlayerRequest authenticationRequest
  );

  @POST("/api/automationTask/getOne")
  Call<PlayerResponse> getOnePlayer(
      @Header(AUTHORIZATION) String authorization,
      @Body GetOnePlayerRequest authenticationRequest
  );

  @GET("/api/automationTask/getAll")
  Call<List<PlayerResponse>> getAllPlayers(
      @Header(AUTHORIZATION) String authorization
  );

  @DELETE("/api/automationTask/deleteOne/{userId}")
  Call<ResponseBody> deleteUser(
      @Path("userId") String userId,
      @Header(AUTHORIZATION) String authorization
  );
}
