package khorunzhyicom.alex.theposter.presentation.popular;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import java.util.List;

import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector;
import khorunzhyicom.alex.theposter.presentation.common.view.DaggerView;
import khorunzhyicom.alex.theposter.presentation.common.view.RxView;
import khorunzhyicom.alex.theposter.service.models.Movie;

public interface PopularMoviesView extends MvpView, DaggerView<PresentationInjector>, RxView {

    void updateMovies(List<Movie> movies);
}
