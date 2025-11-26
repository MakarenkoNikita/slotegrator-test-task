package com.slotegrator.application.api.authentication.model.request;

public record AuthenticationRequest(
    String email,
    String password
) {

}
