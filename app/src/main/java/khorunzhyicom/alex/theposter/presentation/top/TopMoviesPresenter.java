package khorunzhyicom.alex.theposter.presentation.top;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

public class TopMoviesPresenter extends MvpBasePresenter<TopMoviesView> {

    @Override
    public void attachView(TopMoviesView view) {
        super.attachView(view);
        view.injector().inject(this);
    }
}