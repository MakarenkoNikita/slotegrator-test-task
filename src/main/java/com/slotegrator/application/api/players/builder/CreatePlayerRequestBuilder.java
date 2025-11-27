package com.slotegrator.application.api.players.builder;

import com.slotegrator.application.api.players.model.request.CreatePlayerRequest;
import com.slotegrator.application.entity.user.User;

public class CreatePlayerRequestBuilder {

  public CreatePlayerRequest buildRequest(User user) {
    CreatePlayerRequest request = new CreatePlayerRequest();
    request.email = user.email;
    request.password_change = user.password;
    request.password_repeat = user.password;
    request.name = user.name;
    request.surname = user.surename;
    request.username = user.username;
    request.currencyCode = user.currencyCode;
    return request;
  }
}
