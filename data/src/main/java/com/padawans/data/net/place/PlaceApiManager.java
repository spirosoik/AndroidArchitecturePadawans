package com.padawans.data.net.place;

import com.padawans.data.entities.place.mapper.PlaceEntityDataMapper;
import com.padawans.data.net.Constants;
import com.padawans.data.net.common.event.ErrorEvent;
import com.padawans.data.net.common.response.Venue;
import com.padawans.data.net.common.response.VenueGroup;
import com.padawans.data.net.place.event.ExploreEvent;
import com.squareup.otto.Bus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
@Singleton public class PlaceApiManager implements PlaceRest {

  private final PlaceApiRest placeApiService;

  private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");

  private final Bus bus;
  private final PlaceEntityDataMapper placeEntityDataMapper;

  @Inject public PlaceApiManager(Bus bus, PlaceEntityDataMapper placeEntityDataMapper) {

    RestAdapter placeApiRest = new RestAdapter.Builder().setEndpoint(Constants.API_URL)
        .setLogLevel(RestAdapter.LogLevel.HEADERS_AND_ARGS)
        .build();

    this.placeApiService = placeApiRest.create(PlaceApiRest.class);
    this.bus = bus;
    this.placeEntityDataMapper = placeEntityDataMapper;
  }

  @Override public void getPlaces(String ll, Integer limit, Integer sortByDistance) {

    this.placeApiService.explore(1, ll, limit, sortByDistance, dateFormatter.format(new Date()),
        new Callback<com.padawans.data.net.place.response.explore.Explore>() {
          @Override public void success(
              com.padawans.data.net.place.response.explore.Explore explore, Response response) {
            List<Venue> venues = new ArrayList<Venue>();
            if (explore.response.groups.size() > 0) {
              for (VenueGroup group : explore.response.groups) {
                for (com.padawans.data.net.common.response.VenueItem item : group.getItems()) {
                  venues.add(item.venue);
                }
              }
              bus.post(new ExploreEvent(placeEntityDataMapper.transform(venues), response));
            } else {
              bus.post(new ErrorEvent("Data empty"));
            }
          }

          @Override public void failure(RetrofitError error) {
            bus.post(new ExploreEvent(error));
          }
        });
  }
}
