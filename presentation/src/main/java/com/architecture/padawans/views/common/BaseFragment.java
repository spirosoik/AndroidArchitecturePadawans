package com.architecture.padawans.views.common;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.Bind;
import com.architecture.padawans.R;
import com.architecture.padawans.internal.di.HasComponent;

/**
 * Base {@link android.app.Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment {

  @Bind(R.id.rlProgress) protected RelativeLayout progressBar;
  @Bind(R.id.pgBar) protected ProgressBar pgBar;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  /**
   * Shows a {@link android.widget.Toast} message.
   *
   * @param message An string representing a message to be shown.
   */
  protected void showToastMessage(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }

  /**
   * Gets a component for dependency injection by its type.
   */
  @SuppressWarnings("unchecked") protected <C> C getComponent(Class<C> componentType) {
    return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
  }

  public Context getContext() {
    return this.getActivity().getApplicationContext();
  }

  /**
   * Shows a loading view
   */
  protected void showViewLoading() {
    getActivity().runOnUiThread(new Runnable() {
      @Override public void run() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
        pgBar.setVisibility(ProgressBar.VISIBLE);
        getActivity().setProgressBarIndeterminateVisibility(true);
      }
    });
  }

  /**
   * Shows a loading view
   */
  public void hideViewLoading() {
    getActivity().runOnUiThread(new Runnable() {
      @Override public void run() {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        pgBar.setVisibility(ProgressBar.INVISIBLE);
        getActivity().setProgressBarIndeterminateVisibility(false);
      }
    });
  }

  /**
   * Initializes the fragment with Presenter and injection
   */
  protected abstract void initialize();

  /**
   * Setups the UI
   */
  protected abstract void setupUI();
}