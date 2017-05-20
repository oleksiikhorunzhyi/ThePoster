package khorunzhyicom.alex.theposter.presentation.popular;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import khorunzhyicom.alex.theposter.R;
import khorunzhyicom.alex.theposter.App;
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector;
import khorunzhyicom.alex.theposter.presentation.common.controller.ButterKnifeController;
import khorunzhyicom.alex.theposter.presentation.common.controller.RxMvpController;
import khorunzhyicom.alex.theposter.service.models.Movie;

public class PopularMoviesController extends ButterKnifeController<PopularMoviesView, PopularMoviesPresenter> implements PopularMoviesView {

    @NonNull
    @Override
    public PopularMoviesPresenter createPresenter() {
        return new PopularMoviesPresenter();
    }

    @Override
    public PresentationInjector injector() {
        return ((App)getApplicationContext()).apiComponent();
    }

    @NotNull
    @Override
    protected View inflateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        return inflater.inflate(R.layout.controller_popular_movies, container, false);
    }

    @Override
    public void updateMovies(List<Movie> movies) {

    }
}
