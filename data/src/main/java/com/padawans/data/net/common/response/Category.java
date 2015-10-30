package com.padawans.data.net.common.response;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
  public  String id;
  public String name;
  public String pluralName;
  public Icon icon;
  public List<String> parents;
  public Boolean primary;
  public List<Category> categories;

  @Override public String toString() {
    return "Category{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", pluralName='" + pluralName + '\'' +
        ", icon='" + icon + '\'' +
        ", parents=" + parents +
        ", primary=" + primary +
        ", categories=" + categories +
        '}';
  }
}