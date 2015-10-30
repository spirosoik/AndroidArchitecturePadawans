package com.padawans.data.net.user.event;

import com.padawans.data.net.common.event.BaseEvent;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public class LoginEvent extends BaseEvent<Boolean> {

  public LoginEvent(Boolean result, String message) {
    super(result, message);
  }

  public LoginEvent(String error) {
    super(error);
  }
}
