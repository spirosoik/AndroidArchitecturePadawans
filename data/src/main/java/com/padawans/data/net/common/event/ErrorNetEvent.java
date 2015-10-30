package com.padawans.data.net.common.event;

import retrofit.RetrofitError;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public class ErrorNetEvent extends BaseNetEvent {

  public ErrorNetEvent(RetrofitError error) {
    super(error);
  }
}
