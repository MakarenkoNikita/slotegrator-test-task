package com.slotegrator.registration;

import static com.slotegrator.framework.context.constant.StaticContext.environmentConfiguration;
import static com.slotegrator.framework.context.dynamic.DynamicContext.userList;

import com.slotegrator.application.entity.user.UserProvider;
import com.slotegrator.application.service.api.login.LoginApiOperations;
import com.slotegrator.application.service.api.players.PlayersApiOperations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterVerifyAndDeleteUserTest {

  private final int userCount = 12;
  private final UserProvider userProvider = new UserProvider();
  private final PlayersApiOperations playersApiOperations = new PlayersApiOperations();

  @BeforeEach
  void generateUserAndLoginToApplication() {
    for (int iteration = 1; iteration <= userCount; iteration++) {
      userList.add(userProvider.generateRandomUser());
    }
    new LoginApiOperations().loginAndUpdateAccessToken(
        environmentConfiguration.getLogin(), environmentConfiguration.getPassword()
    );
  }

  @Test
  public void loginTest() {
    userList.forEach(playersApiOperations::createUserAndVerifyResponse);
    playersApiOperations.getAndVerifyUser(userList.get(0));
    playersApiOperations.getAllUsersAndFilterByName();
    playersApiOperations.deleteAllUsers();
    playersApiOperations.verifyUserListIsEmpty();
  }
}
