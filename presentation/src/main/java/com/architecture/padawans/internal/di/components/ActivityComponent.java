package com.architecture.padawans.internal.di.components;

import android.app.Activity;
import com.architecture.padawans.internal.di.PerActivity;
import com.architecture.padawans.internal.di.modules.ActivityModule;
import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  //Exposed to sub-graphs.
  Activity activity();
}
