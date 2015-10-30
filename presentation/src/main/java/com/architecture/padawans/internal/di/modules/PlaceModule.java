/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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