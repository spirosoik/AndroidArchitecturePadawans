package com.padawans.data.net.common.response;

import java.util.List;

public class Photos extends Count {

  public List<PhotoGroup> groups;

  @Override public String toString() {
    return "Photos{" +
        "groups=" + groups +
        '}';
  }
}