package com.padawans.data.net.common.event;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public class ErrorEvent extends BaseEvent {

  public ErrorEvent(String error) {
    super(error);
  }
}
