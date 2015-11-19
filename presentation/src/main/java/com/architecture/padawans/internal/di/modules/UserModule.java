package com.architecture.padawans.internal.di.modules;

import com.architecture.padawans.internal.di.PerActivity;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides user related collaborators.
 */
@Module public class UserModule {

  @PerActivity @Provides com.padawans.data.net.user.UserApiManager provideUserDataSource(Bus bus) {
    return new com.padawans.data.net.user.UserApiManager(bus);
  }
}