package khorunzhyicom.alex.theposter.presentation.popular;

import java.util.List;

import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector;
import khorunzhyicom.alex.theposter.presentation.common.view.DaggerView;
import khorunzhyicom.alex.theposter.presentation.common.view.PosterView;
import khorunzhyicom.alex.theposter.service.models.Movie;

public interface PopularMoviesView extends PosterView, DaggerView<PresentationInjector> {

    void updateMovies(List<Movie> movies);

    void showError(String error);
}
