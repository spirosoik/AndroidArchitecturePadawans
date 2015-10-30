package com.padawans.data.net.common.response;

/**
 * Created by Spiros I. Oikonomakis on 11/16/14.
 */

import java.io.Serializable;
import java.util.List;

public class Venue implements Serializable {

  public String id;
  public String name;
  public Contact contact;
  public Location location;
  public List<com.padawans.data.net.common.response.Category> categories;
  public Boolean verified;
  public String url;
  public Double rating;
  public String description;
  public Long createdAt;
  public List<String> tags;
  public com.padawans.data.net.common.response.Count beenHere;
  public String shortUrl;
  public String canonicalUrl;
  public com.padawans.data.net.common.response.Photos photos;
  public Boolean like;
  public Boolean dislike;
  public String timeZone;

  @Override public String toString() {
    return "Venue{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ",\ncontact=" + contact +
        ",\nlocation=" + location +
        ",\ncategories=" + categories +
        ",\nverified=" + verified +
        ",\nurl='" + url + '\'' +
        ",\nrating=" + rating +
        ",\ndescription='" + description + '\'' +
        ", createdAt=" + createdAt +
        ",\ntags=" + tags +
        ",\nbeenHere=" + beenHere +
        ",\nshortUrl='" + shortUrl + '\'' +
        ", canonicalUrl='" + canonicalUrl + '\'' +
        ",\nphotos=" + photos +
        ",\nlike=" + like +
        ", dislike=" + dislike +
        ", timeZone='" + timeZone + '\'' +
        '}';
  }
}
