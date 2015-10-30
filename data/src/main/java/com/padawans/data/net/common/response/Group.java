package com.padawans.data.net.common.response;

import java.util.List;

/**
 * Created by Spiros I. Oikonomakis on 11/16/14.
 */
public abstract class Group<T> extends Count {

  public String type;

  public String name;

  /**
   * Returns group items
   *
   * @return group items
   */
  public abstract List<T> getItems();
}
