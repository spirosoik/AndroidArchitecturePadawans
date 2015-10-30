package com.padawans.data.net.common.response;

import java.util.List;

public class PhotoGroup extends Group<Photo> {

  private List<Photo> items;

  @Override public List<Photo> getItems() {
    return items;
  }

  public void setItems(List<Photo> items) {
    this.items = items;
  }

  @Override public String toString() {
    return "PhotoGroup{" +
        "items=" + items +
        '}';
  }
}