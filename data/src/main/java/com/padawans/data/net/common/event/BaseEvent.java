package com.padawans.data.net.common.event;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public class BaseEvent<T> {

  private T result;

  private String message;

  private String error;

  public BaseEvent(T result, String message) {
    this.result = result;
    this.message = message;
  }

  public BaseEvent(String error) {
    this.error = error;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
