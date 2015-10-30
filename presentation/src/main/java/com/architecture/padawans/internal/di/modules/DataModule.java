package com.architecture.padawans.internal.di.modules;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
@Module public class DataModule {

  @Provides @Singleton Bus providerBus() {
    return new Bus(ThreadEnforcer.MAIN);
  }
}
