package khorunzhyicom.alex.theposter.presentation.popular;

import android.util.Log;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.techery.janet.helper.ActionStateToActionTransformer;
import khorunzhyicom.alex.theposter.service.composers.CommandResultComposer;
import khorunzhyicom.alex.theposter.service.interactors.MoviesInteractor;
import khorunzhyicom.alex.theposter.service.models.Movie;
import rx.Observable;

public class PopularMoviesPresenter extends MvpBasePresenter<PopularMoviesView> {

    @Inject MoviesInteractor moviesInteractor;

    @Override
    public void attachView(PopularMoviesView view) {
        super.attachView(view);
        view.injector().inject(this);
        subscribeToMoviesUpdates();
        Observable.timer(1L, TimeUnit.SECONDS).take(1).subscribe(i -> moviesInteractor.requestPopularMovies());
    }

    private void subscribeToMoviesUpdates() {
        moviesInteractor.popularMoviesPipe()
                .observe()
                .compose(new ActionStateToActionTransformer<>())
                .compose(new CommandResultComposer<>())
                .compose(getView()::bindToMainComposer)
                .subscribe(items -> getView().updateMovies(items), this::onItemsLoadedFail);
    }

    private void onItemsLoadedFail(Throwable throwable) {
        Log.e("error", throwable.getLocalizedMessage());
    }
}
