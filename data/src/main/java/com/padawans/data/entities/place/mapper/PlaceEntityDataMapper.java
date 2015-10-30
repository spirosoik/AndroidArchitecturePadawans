package com.padawans.data.entities.place.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
@Singleton public class PlaceEntityDataMapper {

  private final com.padawans.data.entities.category.mapper.CategoryEntityDataMapper
      categoryEntityDataMapper;

  @Inject public PlaceEntityDataMapper(
      com.padawans.data.entities.category.mapper.CategoryEntityDataMapper categoryEntityDataMapper) {
    if (categoryEntityDataMapper == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.categoryEntityDataMapper = categoryEntityDataMapper;
  }

  public com.padawans.data.entities.place.PlaceEntity transform(
      com.padawans.data.net.common.response.Venue venue) {
    com.padawans.data.entities.place.PlaceEntity place = null;
    if (venue != null) {
      place = new com.padawans.data.entities.place.PlaceEntity();
      place.setId(venue.id);
      place.setName(venue.name);

      if (venue.location != null) {
        place.setCountry(venue.location.country);
        place.setCity(venue.location.city);
        place.setAddress(venue.location.address);
        place.setDistance(venue.location.distance);
        place.setLat(venue.location.lat);
        place.setLng(venue.location.lng);
      }

      if (venue.photos != null && venue.photos.groups != null && venue.photos.groups.size() > 0) {

        com.padawans.data.net.common.response.PhotoGroup photoGroup = venue.photos.groups.get(0);
        if (photoGroup != null) {
          if (photoGroup.getItems() != null && photoGroup.getItems().size() > 0) {
            com.padawans.data.net.common.response.Photo photo = photoGroup.getItems().get(0);
            if (photo != null) {
              StringBuilder sb = new StringBuilder().append(photo.prefix).append("100x100").append(
                  photo.suffix);
              place.setPhoto(sb.toString());
            }
          }
        }
      }
      if (venue.categories != null) {
        place.setCategories(this.categoryEntityDataMapper.transform(venue.categories));
      }
    }
    return place;
  }

  public List<com.padawans.data.entities.place.PlaceEntity> transform(Collection<com.padawans.data.net.common.response.Venue> venueCollection) {
    List<com.padawans.data.entities.place.PlaceEntity> placeEntityList = new ArrayList<>();
    com.padawans.data.entities.place.PlaceEntity place = null;
    for (com.padawans.data.net.common.response.Venue venue : venueCollection) {
      place = transform(venue);
      if (place != null) {
        placeEntityList.add(place);
      }
    }
    return placeEntityList;
  }
}
