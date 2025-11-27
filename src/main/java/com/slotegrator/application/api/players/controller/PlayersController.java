package com.slotegrator.application.api.players.controller;

import static com.slotegrator.framework.context.dynamic.DynamicContext.cookieSession;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.slotegrator.application.api.players.builder.CreatePlayerRequestBuilder;
import com.slotegrator.application.api.players.model.request.GetOnePlayerRequest;
import com.slotegrator.application.api.players.model.response.PlayerResponse;
import com.slotegrator.application.api.players.service.PlayersService;
import com.slotegrator.application.entity.user.User;
import com.slotegrator.framework.api.retrofit.RetrofitServiceBuilder;
import java.io.IOException;
import java.util.List;
import retrofit2.Response;

public class PlayersController {

  private final PlayersService playersService = new RetrofitServiceBuilder().buildService(PlayersService.class);

  public PlayerResponse createPlayer(User user) {
    Response<PlayerResponse> response;
    try {
      response = playersService.createPlayer(
          "Bearer " + cookieSession.getAccessToken(), new CreatePlayerRequestBuilder().buildRequest(user)
      ).execute();
    } catch (IOException e) {
      throw new IllegalArgumentException(format("Error during execution: %s", e.getMessage()));
    }
    int expectedResponseStatusCode = 201;
    assertEquals(expectedResponseStatusCode, response.code());
    return response.body();
  }

  public PlayerResponse getOnePlayer(String email) {
    Response<PlayerResponse> response;
    try {
      response = playersService.getOnePlayer(
          "Bearer " + cookieSession.getAccessToken(), new GetOnePlayerRequest(email)
      ).execute();
    } catch (IOException e) {
      throw new IllegalArgumentException(format("Error during execution: %s", e.getMessage()));
    }
    int expectedResponseStatusCode = 200;
    assertEquals(expectedResponseStatusCode, response.code());
    return response.body();
  }

  public List<PlayerResponse> getAllPlayers() {
    List<PlayerResponse> response;
    try {
      response = playersService.getAllPlayers("Bearer " + cookieSession.getAccessToken()).execute().body();
    } catch (IOException e) {
      throw new IllegalArgumentException(format("Error during execution: %s", e.getMessage()));
    }
    return response;
  }

  public void deleteUser(String userId) {
    try {
      playersService.deleteUser(
          userId, "Bearer " + cookieSession.getAccessToken()
      ).execute();
    } catch (IOException e) {
      throw new IllegalArgumentException(format("Error during execution: %s", e.getMessage()));
    }
  }
}
