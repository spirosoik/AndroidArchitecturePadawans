package com.padawans.data.net.place;

import com.padawans.data.net.Constants;
import com.padawans.data.net.place.response.explore.Explore;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface PlaceApiRest {

  @GET("/venues/explore?client_id="
      + Constants.API_CLIENT_ID
      + "&client_secret="
      + Constants.API_CLIENT_SECRET)
  void explore(@Query("venuePhotos") Integer venuePhotos, @Query("ll") String ll,
      @Query("limit") Integer limit,
      @Query("sortByDistance") Integer sortByDistance,
      @Query("v") String date,
      Callback<Explore> response);
}