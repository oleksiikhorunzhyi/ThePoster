package khorunzhyicom.alex.theposter.di.components.injector;

import khorunzhyicom.alex.theposter.presentation.activity.PosterActivity;
import khorunzhyicom.alex.theposter.presentation.popular.PopularMoviesPresenter;
import khorunzhyicom.alex.theposter.presentation.top.TopMoviesPresenter;

public interface PresentationInjector extends Injector {

    void inject(PopularMoviesPresenter presenter);
    void inject(TopMoviesPresenter presenter);
    void inject(PosterActivity activity);
}
