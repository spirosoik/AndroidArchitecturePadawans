package com.architecture.padawans.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Spiros I. Oikonomakis on 10/30/15.
 */
@Singleton public class AuthDbManager {

  public static final String AUTH_ATTR = "AUTH_ATTR";
  private static final String PREFERENCE_NAME = "AUTH_DB";
  private Editor prefEditor;
  private SharedPreferences preferences;

  @Inject public AuthDbManager(Context context) {
    preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    prefEditor = preferences.edit();
  }

  /**
   * Sets if a user is authenticated or not. Basically creates a Session
   * @param status boolean
   */
  public void setAuthenticated(boolean status) {
    this.prefEditor.putBoolean(AUTH_ATTR, status);
    this.prefEditor.commit();
  }

  /**
   * Checks if the user is authenticated
   *
   * @return boolean
   */
  public boolean isAuthenticated() {
    return this.preferences.getBoolean(AUTH_ATTR, false);
  }

  /**
   * Clears the session
   */
  public void logout() {
    this.prefEditor.clear();
    this.prefEditor.commit();
  }
}
