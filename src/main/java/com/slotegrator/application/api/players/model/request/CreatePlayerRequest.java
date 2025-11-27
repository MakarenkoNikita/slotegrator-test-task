package com.slotegrator.application.api.players.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slotegrator.application.domain.currency.CurrencyType;

public class CreatePlayerRequest {

  public String email;
  public String password_change;
  public String password_repeat;
  public String name;
  public String surname;
  public String username;
  @JsonProperty("currency_code")
  public CurrencyType currencyCode;
}
