package com.padawans.data.net.place;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public interface PlaceRest {

  void getPlaces(String ll, Integer limit, Integer sortByDistance);
}
