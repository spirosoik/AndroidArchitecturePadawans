package com.padawans.data.net.user;

import com.padawans.data.net.user.event.LoginEvent;
import com.squareup.otto.Bus;
import javax.inject.Inject;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public class UserApiManager implements UserRest {

  private final Bus bus;

  @Inject public UserApiManager(Bus bus) {
    this.bus = bus;
  }

  @Override public void login(String username, String password) {
    if ("user1".equalsIgnoreCase(username.toLowerCase()) && "1234".equalsIgnoreCase(
        password.toUpperCase())) {
      bus.post(new LoginEvent(true, "You are in!!!"));
    } else {
      bus.post(new LoginEvent(false, "Wrong credentials"));
    }
  }
}
