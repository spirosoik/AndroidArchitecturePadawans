package com.padawans.data.net.common.event;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public class BaseNetEvent<T> {

  private T result;

  private Response response;

  private RetrofitError error;

  public BaseNetEvent(T result, Response response) {
    this.result = result;
    this.response = response;
  }

  public BaseNetEvent(RetrofitError error) {
    this.error = error;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }

  public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }

  public RetrofitError getError() {
    return error;
  }

  public void setError(RetrofitError error) {
    this.error = error;
  }
}
