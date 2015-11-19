package com.architecture.padawans.internal.di.modules;

import android.content.Context;
import com.architecture.padawans.BaseApplication;
import com.architecture.padawans.managers.AuthDbManager;
import com.architecture.padawans.navigation.Navigator;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module public class ApplicationModule {
  private final BaseApplication application;

  public ApplicationModule(BaseApplication application) {
    this.application = application;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton Navigator provideNavigator() {
    return new Navigator();
  }

  @Provides @Singleton AuthDbManager provideAuthManager(Context context) {
    return new AuthDbManager(context);
  }
}
