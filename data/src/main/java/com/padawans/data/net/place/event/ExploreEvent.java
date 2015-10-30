package com.padawans.data.net.place.event;

import com.padawans.data.entities.place.PlaceEntity;
import java.util.List;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public class ExploreEvent extends
    com.padawans.data.net.common.event.BaseNetEvent<List<PlaceEntity>> {

  public ExploreEvent(List<com.padawans.data.entities.place.PlaceEntity> result, Response response) {
    super(result, response);
  }

  public ExploreEvent(RetrofitError error) {
    super(error);
  }
}
