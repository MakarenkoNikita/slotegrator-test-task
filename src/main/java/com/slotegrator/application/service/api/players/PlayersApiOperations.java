package com.slotegrator.application.service.api.players;

import static com.slotegrator.framework.execution.CustomLogger.getLogger;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.slotegrator.application.api.players.controller.PlayersController;
import com.slotegrator.application.api.players.model.response.PlayerResponse;
import com.slotegrator.application.entity.user.User;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.Logger;

public class PlayersApiOperations {

  private final Logger log = getLogger();
  private final PlayersController playersController = new PlayersController();

  public void createUserAndVerifyResponse(User user) {
    log.info("[Step] Create user [{}]", user);
    PlayerResponse response = playersController.createPlayer(user);
    verifyUserResponse(user, response);
  }

  public void getAndVerifyUser(User user) {
    log.info("[Verification] Value for [{}] user", user.email);
    PlayerResponse response = playersController.getOnePlayer(user.email);
    verifyUserResponse(user, response);
  }

  public void getAllUsersAndFilterByName() {
    log.info("[Step] Get all users and filter by name");
    List<PlayerResponse> userList = playersController.getAllPlayers();
    userList.sort(Comparator.comparing(PlayerResponse::name));
    log.info("[Step] Sorted user list:\n{}", userList);
  }

  public void verifyUserListIsEmpty() {
    log.info("[Verification] User list is empty");
    List<PlayerResponse> userList = playersController.getAllPlayers();
    assertTrue(userList.isEmpty(), "User list must be empty");
  }

  public void deleteAllUsers() {
    log.info("[Step] Delete all users");
    List<PlayerResponse> userList = playersController.getAllPlayers();
    userList.forEach(user -> playersController.deleteUser(user.id()));
  }

  private void verifyUserResponse(User expectedUser, PlayerResponse response) {
    assertNotNull(response, "Response body is null");
    assertAll(
        () -> assertFalse(response.id().isBlank(), "ID is empty"),
        () -> assertEquals(expectedUser.email, response.email(), "Expected and actual emails must be equals"),
        () -> assertEquals(expectedUser.username, response.username(), "Expected and actual username must be equals"),
        () -> assertEquals(expectedUser.name, response.name(), "Expected and actual emails name be equals"),
        () -> assertEquals(expectedUser.surename, response.surname(), "Expected and actual surename must be equals")
    );
  }
}
