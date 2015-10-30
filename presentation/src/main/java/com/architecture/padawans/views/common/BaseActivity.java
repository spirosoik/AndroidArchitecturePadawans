package com.architecture.padawans.views.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.architecture.padawans.BaseApplication;
import com.architecture.padawans.internal.di.components.AppComponent;
import com.architecture.padawans.managers.AuthDbManager;
import com.architecture.padawans.navigation.Navigator;
import com.architecture.padawans.internal.di.modules.ActivityModule;
import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {

  @Inject protected Navigator navigator;

  @Inject protected AuthDbManager authDbManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    this.getApplicationComponent().inject(this);

    this.initializeActivity(savedInstanceState);
    this.initializeInjector();
  }

  /**
   * Adds a {@link Fragment} to this activity's layout.
   *
   * @param containerViewId The container view to where add the fragment.
   * @param fragment The fragment to be added.
   */
  protected void addFragment(int containerViewId, Fragment fragment) {
    FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
    fragmentTransaction.add(containerViewId, fragment);
    fragmentTransaction.commit();
  }

  /**
   * Get the Main Application component for dependency injection.
   */
  protected AppComponent getApplicationComponent() {
    return ((BaseApplication) getApplication()).getApplicationComponent();
  }

  /**
   * Get an Activity module for dependency injection.
   */
  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }

  /**
   * Abstract Initialises injector for each activity
   */
  protected abstract void initializeInjector();

  /**
   * Initialize activity
   *
   * @param savedInstanceState {@link Bundle}
   */
  protected abstract void initializeActivity(Bundle savedInstanceState);
}