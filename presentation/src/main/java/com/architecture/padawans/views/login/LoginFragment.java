package com.architecture.padawans.views.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.architecture.padawans.R;
import com.architecture.padawans.views.common.BaseFragment;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import javax.inject.Inject;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
public class LoginFragment extends BaseFragment {

  /**
   * Interface for listening user list events.
   */
  public interface LoginListener {
    void onSuccessLogin();
  }
  // UI

  @Bind(R.id.edtUsername) EditText edtUsername;

  @Bind(R.id.edtPassword) EditText edtPasword;

  // Config
  @Inject Bus bus;

  @Inject com.padawans.data.net.user.UserApiManager userApiManager;

  private LoginListener loginListener;

  public LoginFragment() {
    super();
  }

  public static LoginFragment newInstance() {
    return new LoginFragment();
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (activity instanceof LoginListener) {
      this.loginListener = (LoginListener) activity;
    }
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_login, container, false);

    ButterKnife.bind(this, fragmentView);

    return fragmentView;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.initialize();
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
    this.getComponent(LoginComponent.class).inject(this);
  }

  @Override protected void setupUI() {

  }

  @OnClick(R.id.btnSignIn) public void onSignInClick() {
    if (TextUtils.isEmpty(edtUsername.getText())) {
      edtUsername.setError("Cannot be empty");
      return;
    }
    if (TextUtils.isEmpty(edtPasword.getText())) {
      edtPasword.setError("Cannot be empty");
      return;
    }

    userApiManager.login(edtUsername.getText().toString(), edtPasword.getText().toString());
  }

  // EVENTS SUBSCRIBER
  @Subscribe public void onLoginEvent(com.padawans.data.net.user.event.LoginEvent event) {
    if (event.getResult()) {
      this.loginListener.onSuccessLogin();
    } else {
      this.edtUsername.setError("Wrong username");
      this.edtPasword.setError("Wrong password");
    }
    Toast.makeText(getContext(), event.getMessage(), Toast.LENGTH_LONG).show();
  }
}
