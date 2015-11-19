package com.architecture.padawans;

import android.app.Application;
import com.architecture.padawans.internal.di.components.AppComponent;
import com.architecture.padawans.internal.di.components.DaggerAppComponent;
import com.architecture.padawans.internal.di.modules.ApplicationModule;

/**
 * Android Main Application
 */
public class BaseApplication extends Application {

  private AppComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    this.initializeInjector();
  }

  private void initializeInjector() {
    this.applicationComponent = DaggerAppComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public AppComponent getApplicationComponent() {
    return this.applicationComponent;
  }
}
