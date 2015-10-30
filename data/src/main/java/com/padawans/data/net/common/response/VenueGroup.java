package com.padawans.data.net.common.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Spiros I. Oikonomakis on 11/16/14.
 */
public class VenueGroup extends Group<VenueItem> implements Serializable {

  private List<VenueItem> items;

  @Override public List<VenueItem> getItems() {
    return items;
  }

  public void setItems(List<VenueItem> items) {
    this.items = items;
  }
}
