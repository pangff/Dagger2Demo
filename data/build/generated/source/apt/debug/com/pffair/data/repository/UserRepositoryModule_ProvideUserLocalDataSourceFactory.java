// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.pffair.data.repository;

import android.content.Context;
import com.pffair.data.repository.datasource.UserDataSource;
import com.pffair.data.repository.module.UserRepositoryModule;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class UserRepositoryModule_ProvideUserLocalDataSourceFactory
    implements Factory<UserDataSource> {
  private final UserRepositoryModule module;

  private final Provider<Context> contextProvider;

  public UserRepositoryModule_ProvideUserLocalDataSourceFactory(
      UserRepositoryModule module, Provider<Context> contextProvider) {
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public UserDataSource get() {
    return Preconditions.checkNotNull(
        module.provideUserLocalDataSource(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<UserDataSource> create(
      UserRepositoryModule module, Provider<Context> contextProvider) {
    return new UserRepositoryModule_ProvideUserLocalDataSourceFactory(module, contextProvider);
  }
}
