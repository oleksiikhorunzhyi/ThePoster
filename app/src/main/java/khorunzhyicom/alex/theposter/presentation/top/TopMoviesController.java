package khorunzhyicom.alex.theposter.presentation.top;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.conductor.MvpController;

import khorunzhyicom.alex.theposter.R;
import khorunzhyicom.alex.theposter.application.App;
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector;
import khorunzhyicom.alex.theposter.presentation.common.controller.RxMvpController;

public class TopMoviesController extends RxMvpController<TopMoviesView, TopMoviesPresenter> implements TopMoviesView {

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.controller_top_movies, viewGroup, false);
    }

    @NonNull
    @Override
    public TopMoviesPresenter createPresenter() {
        return new TopMoviesPresenter();
    }

    @Override
    public PresentationInjector injector() {
        return ((App)getApplicationContext()).apiComponent();
    }
}
