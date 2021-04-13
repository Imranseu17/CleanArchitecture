// Generated by Dagger (https://dagger.dev).
package com.test.moviehub.domain;

import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SearchMovies_Factory implements Factory<SearchMovies> {
  private final Provider<Repository> repositoryProvider;

  public SearchMovies_Factory(Provider<Repository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SearchMovies get() {
    return newInstance(repositoryProvider.get());
  }

  public static SearchMovies_Factory create(Provider<Repository> repositoryProvider) {
    return new SearchMovies_Factory(repositoryProvider);
  }

  public static SearchMovies newInstance(Repository repository) {
    return new SearchMovies(repository);
  }
}
