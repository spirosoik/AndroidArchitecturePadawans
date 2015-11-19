package com.architecture.padawans.internal.di.modules;

import com.padawans.data.entities.category.mapper.CategoryEntityDataMapper;
import com.padawans.data.entities.place.mapper.PlaceEntityDataMapper;
import com.architecture.padawans.internal.di.PerActivity;
import com.padawans.data.net.place.PlaceApiManager;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides user related collaborators.
 */
@Module public class PlaceModule {

  @Provides @PerActivity CategoryEntityDataMapper provideCategoryEntityDataMapper(Bus bus) {
    return new CategoryEntityDataMapper();
  }

  @Provides @PerActivity PlaceEntityDataMapper providePlaceEntityDataMapper(Bus bus, CategoryEntityDataMapper categoryEntityDataMapper) {
    return new PlaceEntityDataMapper(categoryEntityDataMapper);
  }

  @Provides @PerActivity PlaceApiManager providePlaceDataSource(Bus bus, PlaceEntityDataMapper placeEntityDataMapper) {
    return new PlaceApiManager(bus, placeEntityDataMapper);
  }
}