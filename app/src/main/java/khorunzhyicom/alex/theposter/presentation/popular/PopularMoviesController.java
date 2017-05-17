package khorunzhyicom.alex.theposter.presentation.popular;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import khorunzhyicom.alex.theposter.R;
import khorunzhyicom.alex.theposter.application.App;
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector;
import khorunzhyicom.alex.theposter.presentation.common.controller.RxMvpController;

public class PopularMoviesController extends RxMvpController<PopularMoviesView, PopularMoviesPresenter> implements PopularMoviesView {

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.controller_popular_movies, viewGroup, false);
    }

    @NonNull
    @Override
    public PopularMoviesPresenter createPresenter() {
        return new PopularMoviesPresenter();
    }

    @Override
    public PresentationInjector injector() {
        return ((App)getApplicationContext()).apiComponent();
    }
}
