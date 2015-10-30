package com.architecture.padawans.views.login;

import com.architecture.padawans.internal.di.components.AppComponent;
import com.architecture.padawans.internal.di.modules.UserModule;
import com.architecture.padawans.internal.di.PerActivity;
import com.architecture.padawans.internal.di.modules.ActivityModule;
import dagger.Component;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface LoginComponent {

  void inject(LoginFragment loginFragment);
}
