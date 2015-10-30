package com.architecture.padawans.navigation;

import android.content.Context;
import android.content.Intent;
import com.architecture.padawans.views.login.LoginActivity;
import com.architecture.padawans.views.place.list.PlacesActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 */
@Singleton public class Navigator {

  @Inject public void Navigator() {
    //empty
  }

  /**
   * Goes to the places list screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToPlaceList(Context context) {
    if (context != null) {
      Intent intentToLaunch = PlacesActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the login screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToLogin(Context context) {
    if (context != null) {
      Intent intentToLaunch = LoginActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }
}