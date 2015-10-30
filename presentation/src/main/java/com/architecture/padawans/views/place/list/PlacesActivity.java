package com.architecture.padawans.views.place.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.architecture.padawans.R;
import com.architecture.padawans.internal.di.HasComponent;
import com.architecture.padawans.views.common.BaseActivity;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public class PlacesActivity extends BaseActivity implements HasComponent<PlacesComponent>,
    PlacesFragment.PlaceListListener {

  private PlacesComponent placesComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_fragment);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_places, menu);
    return true;
  }
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    //if you have more items use switch not multiple if/else
    if (item.getItemId() == R.id.action_logout) {
      authDbManager.logout();
      finish();
      navigator.navigateToLogin(this);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override protected void initializeInjector() {
    this.placesComponent = DaggerPlacesComponent.builder()
        .appComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();
  }

  /**
   * Returns the intent for this activity
   *
   * @param context {@link Context}
   * @return {@link Intent}
   */
  public static Intent getCallingIntent(Context context) {
    return new Intent(context, PlacesActivity.class);
  }

  @Override protected void initializeActivity(Bundle savedInstanceState) {
    addFragment(R.id.fragmentContainer, PlacesFragment.newInstance());
  }

  @Override public PlacesComponent getComponent() {
    return this.placesComponent;
  }

  @Override public void onPlaceClicked(
      com.padawans.data.entities.place.PlaceEntity placeEntity) {
  }
}
