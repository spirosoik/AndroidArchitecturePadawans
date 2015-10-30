package com.architecture.padawans.views.place.list;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.architecture.padawans.R;
import com.padawans.data.entities.place.PlaceEntity;
import com.padawans.data.net.place.PlaceApiManager;
import com.padawans.data.net.place.event.ExploreEvent;
import com.architecture.padawans.views.common.BaseFragment;
import com.architecture.padawans.views.place.list.adapter.PlacesAdapter;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public class PlacesFragment extends BaseFragment {

  /**
   * Interface for listening user list events.
   */
  /**
   * Interface for listening user list events.
   */
  public interface PlaceListListener {
    void onPlaceClicked(final PlaceEntity placeEntity);
  }

  // UI
  @Bind(R.id.rvPlaces) RecyclerView rvPlaces;

  // Config
  @Inject PlaceApiManager placeApiManager;

  @Inject Bus bus;

  private PlacesAdapter placesAdapter;

  private PlaceListListener placeListListener;

  public PlacesFragment() {
    super();
  }

  public static PlacesFragment newInstance() {
    return new PlacesFragment();
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (activity instanceof PlaceListListener) {
      this.placeListListener = (PlaceListListener) activity;
    }
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_places, container, false);

    ButterKnife.bind(this, fragmentView);

    setupUI();
    return fragmentView;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.initialize();
    placeApiManager.getPlaces("40.692816,-73.992048", 15, 1);
  }

  @Override public void onStart() {
    super.onStart();
    bus.register(this);
  }

  @Override public void onStop() {
    super.onStop();
    bus.unregister(this);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }

  @Override protected void initialize() {
    this.getComponent(PlacesComponent.class).inject(this);
  }

  @Override protected void setupUI() {
    this.rvPlaces.setLayoutManager(new LinearLayoutManager(getActivity()));
    this.placesAdapter = new PlacesAdapter(getActivity(), new ArrayList<PlaceEntity>());
    this.placesAdapter.setOnItemClickListener(onItemClickListener);
    this.rvPlaces.setAdapter(placesAdapter);
  }

  private PlacesAdapter.OnItemClickListener onItemClickListener =
      new PlacesAdapter.OnItemClickListener() {
        @Override public void onPlaceItemClicked(PlaceEntity placeEntity) {
          if (placeEntity != null) {
            placeListListener.onPlaceClicked(placeEntity);
          }
        }
      };

  // EVENTS SUBSCRIBER
  @Subscribe public void onExploreEvent(ExploreEvent event) {
    this.hideViewLoading();
    if (event.getError() != null) {
      Toast.makeText(getContext(), event.getError().getMessage(), Toast.LENGTH_LONG).show();
    } else {
      this.placesAdapter.setPlacesCollection(event.getResult());
    }
  }
}
