package com.architecture.padawans.views.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.architecture.padawans.R;
import com.architecture.padawans.internal.di.HasComponent;
import com.architecture.padawans.views.common.BaseActivity;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public class LoginActivity extends BaseActivity implements HasComponent<LoginComponent>,
    LoginFragment.LoginListener {

  private LoginComponent loginComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    setContentView(R.layout.activity_fragment);
  }

  @Override protected void initializeInjector() {
    this.loginComponent = DaggerLoginComponent.builder()
        .appComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();

  }

  @Override protected void initializeActivity(Bundle savedInstanceState) {

    // If I am already authenticated move to main screen
    if (authDbManager.isAuthenticated()) {
      this.navigator.navigateToPlaceList(this);
      finish();
    }
    addFragment(R.id.fragmentContainer, LoginFragment.newInstance());
  }

  /**
   * Returns the intent for this activity
   *
   * @param context {@link Context}
   * @return {@link Intent}
   */
  public static Intent getCallingIntent(Context context) {
    return new Intent(context, LoginActivity.class);
  }

  @Override public LoginComponent getComponent() {
    return this.loginComponent;
  }

  @Override public void onSuccessLogin() {
    authDbManager.setAuthenticated(true);
    this.navigator.navigateToPlaceList(this);
    finish();
  }
}
