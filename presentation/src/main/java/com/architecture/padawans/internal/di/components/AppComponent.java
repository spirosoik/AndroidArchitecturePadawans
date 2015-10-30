package com.architecture.padawans.internal.di.components;

import android.content.Context;
import com.architecture.padawans.internal.di.modules.ApplicationModule;
import com.architecture.padawans.internal.di.modules.DataModule;
import com.architecture.padawans.views.common.BaseActivity;
import com.squareup.otto.Bus;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
@Singleton
@Component(modules = { ApplicationModule.class, DataModule.class })
public interface AppComponent {

  void inject(BaseActivity baseActivity);

  //Exposed to sub-graphs.
  Context context();
  Bus bus();

}
