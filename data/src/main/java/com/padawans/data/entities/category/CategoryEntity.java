package com.padawans.data.entities.category;

import java.io.Serializable;

/**
 * Created by Spiros I. Oikonomakis on 11/16/14.
 */
public class CategoryEntity implements Serializable {

  private String id;

  private String name;

  public String prefixImageUrl;

  public String suffixImage;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrefixImageUrl() {
    return prefixImageUrl;
  }

  public void setPrefixImageUrl(String prefixImageUrl) {
    this.prefixImageUrl = prefixImageUrl;
  }

  public String getSuffixImage() {
    return suffixImage;
  }

  public void setSuffixImage(String suffixImage) {
    this.suffixImage = suffixImage;
  }

  public String getUrl(int size, boolean bg) {
    String background = bg ? "bg" : "";
    return prefixImageUrl + background + "_" + size + suffixImage;
  }

  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("CategoryEntity{");
    sb.append("id='").append(id).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", prefixImageUrl='").append(prefixImageUrl).append('\'');
    sb.append(", suffixImage='").append(suffixImage).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
