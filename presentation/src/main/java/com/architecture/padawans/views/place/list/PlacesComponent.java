package com.architecture.padawans.views.place.list;

import com.architecture.padawans.internal.di.modules.PlaceModule;
import com.architecture.padawans.internal.di.PerActivity;
import com.architecture.padawans.internal.di.components.AppComponent;
import com.architecture.padawans.internal.di.modules.ActivityModule;
import dagger.Component;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, PlaceModule.class})
public interface PlacesComponent {

  void inject(PlacesFragment placesFragment);


  //Exposed to sub-graphs.
}
