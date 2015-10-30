package com.padawans.data.net.place.response.explore;

import com.padawans.data.net.common.response.Response;
import com.padawans.data.net.common.response.VenueGroup;
import java.io.Serializable;

/**
 * Created by Spiros I. Oikonomakis on 11/16/14.
 */
public class Explore implements Serializable {

  public Response<VenueGroup> response;

  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("Explore{");
    sb.append("response=").append(response);
    sb.append('}');
    return sb.toString();
  }
}
