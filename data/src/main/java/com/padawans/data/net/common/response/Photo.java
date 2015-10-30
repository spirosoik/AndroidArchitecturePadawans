package com.padawans.data.net.common.response;

import java.io.Serializable;

public class Photo implements Serializable {
  public String id;
  public String suffix;
  public String prefix;

  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("Photo{");
    sb.append("id='").append(id).append('\'');
    sb.append(", suffix=").append(suffix);
    sb.append(", prefix='").append(prefix).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
