package com.slotegrator.application.api.players.model.response;

public record PlayerResponse(
    String id,
    String username,
    String email,
    String name,
    String surname
) {

}
