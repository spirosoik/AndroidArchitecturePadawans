package com.padawans.data.net.common.response;

import java.io.Serializable;

public class Contact implements Serializable {

  public String email;
  public String facebook;
  public String twitter;
  public String phone;
  public String formattedPhone;

  @Override public String toString() {
    return "Contact{" +
        "email='" + email + '\'' +
        ", facebook='" + facebook + '\'' +
        ", twitter='" + twitter + '\'' +
        ", phone='" + phone + '\'' +
        ", formattedPhone='" + formattedPhone + '\'' +
        '}';
  }
}