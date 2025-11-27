package com.slotegrator.application.entity.user;

import static com.slotegrator.application.domain.currency.CurrencyType.USD;
import static com.slotegrator.framework.generator.EmailGenerator.generateRandomEmail;
import static com.slotegrator.framework.generator.PasswordGenerator.generateRandomPassword;
import static com.slotegrator.framework.generator.StringGenerator.generateRandomString;

public class UserProvider {

  public User generateRandomUser() {
    User user = new User();
    user.email = generateRandomEmail();
    user.password = generateRandomPassword();
    user.name = generateRandomString(15);
    user.surename = generateRandomString(15);
    user.username = generateRandomString(15);
    user.currencyCode = USD;
    return user;
  }
}
