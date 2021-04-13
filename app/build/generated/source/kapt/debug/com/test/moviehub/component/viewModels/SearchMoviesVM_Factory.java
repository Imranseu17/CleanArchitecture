// Generated by Dagger (https://dagger.dev).
package com.test.moviehub.component.viewModels;

import com.test.moviehub.domain.SearchMovies;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SearchMoviesVM_Factory implements Factory<SearchMoviesVM> {
  private final Provider<SearchMovies> searchMoviesProvider;

  public SearchMoviesVM_Factory(Provider<SearchMovies> searchMoviesProvider) {
    this.searchMoviesProvider = searchMoviesProvider;
  }

  @Override
  public SearchMoviesVM get() {
    return newInstance(searchMoviesProvider.get());
  }

  public static SearchMoviesVM_Factory create(Provider<SearchMovies> searchMoviesProvider) {
    return new SearchMoviesVM_Factory(searchMoviesProvider);
  }

  public static SearchMoviesVM newInstance(SearchMovies searchMovies) {
    return new SearchMoviesVM(searchMovies);
  }
}
