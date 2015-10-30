package com.padawans.data.net.common.response;

import java.io.Serializable;

public class Count implements Serializable {

  public Long count;

  @Override public String toString() {
    return "Count{" +
        "count=" + count +
        '}';
  }
}