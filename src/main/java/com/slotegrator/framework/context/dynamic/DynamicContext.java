package com.slotegrator.framework.context.dynamic;

import com.slotegrator.application.entity.user.User;
import java.util.ArrayList;
import java.util.List;

public class DynamicContext {

  public static final CookieSession cookieSession = new CookieSession();
  public static final List<User> userList = new ArrayList<>();

  private DynamicContext() {
  }
}
