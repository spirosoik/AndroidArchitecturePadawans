/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
