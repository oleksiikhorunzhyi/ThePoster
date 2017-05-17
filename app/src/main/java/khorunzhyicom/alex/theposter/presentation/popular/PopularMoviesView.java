package khorunzhyicom.alex.theposter.presentation.popular;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector;
import khorunzhyicom.alex.theposter.presentation.common.view.DaggerView;
import khorunzhyicom.alex.theposter.presentation.common.view.RxView;

public interface PopularMoviesView extends MvpView, DaggerView<PresentationInjector>, RxView {
}
