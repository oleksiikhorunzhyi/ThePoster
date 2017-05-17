package khorunzhyicom.alex.theposter.service.interactors;


import io.techery.janet.ActionPipe;
import io.techery.janet.Janet;
import io.techery.janet.ReadActionPipe;
import khorunzhyicom.alex.theposter.service.commands.GetPopularMoviesCommand;
import rx.schedulers.Schedulers;

/**
 * Author: Alexei Khorunzhyi
 * Date: 10.05.17.
 * Date: 20:06.
 */
public class MoviesInteractor {

    private final ActionPipe<GetPopularMoviesCommand> popularMoviesPipe;

    public MoviesInteractor(Janet janet) {
        this.popularMoviesPipe = janet.createPipe(GetPopularMoviesCommand.class, Schedulers.io());
    }

    public ReadActionPipe<GetPopularMoviesCommand> popularMoviesPipe() {
        return popularMoviesPipe;
    }

    public void requestPopularMovies() {
        popularMoviesPipe.send(new GetPopularMoviesCommand());
    }
}
