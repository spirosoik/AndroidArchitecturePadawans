package com.padawans.data.net.common.response;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Spiros I. Oikonomakis on 11/16/14.
 */
public class Response<T> implements Serializable {

  public ArrayList<T> groups;


  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("Response{");
    sb.append("groups=").append(groups);
    sb.append('}');
    return sb.toString();
  }
}
