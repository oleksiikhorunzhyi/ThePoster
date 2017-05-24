package khorunzhyicom.alex.theposter.presentation.top;


import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector;
import khorunzhyicom.alex.theposter.presentation.common.view.DaggerView;
import khorunzhyicom.alex.theposter.presentation.common.view.PosterView;

public interface TopMoviesView extends PosterView, DaggerView<PresentationInjector> {
}
