package com.padawans.data.net.common.response;

import java.io.Serializable;

/**
 * Created by Spiros I. Oikonomakis on 11/16/14.
 */
public class Icon  implements Serializable {

  public String prefix;
  public String suffix;

  public String getUrl(int size, boolean bg) {
    String background = bg ? "bg" : "";
    return prefix + background + "_" + size + suffix;
  }
}