package khorunzhyicom.alex.theposter.api.actions.movies;

import java.util.List;

import io.techery.janet.http.annotations.HttpAction;
import io.techery.janet.http.annotations.Response;
import khorunzhyicom.alex.theposter.api.actions.common.PosterHttpAction;
import khorunzhyicom.alex.theposter.api.actions.common.Responsible;
import khorunzhyicom.alex.theposter.api.entities.MovieEntity;
import khorunzhyicom.alex.theposter.api.entities.MoviesHolder;

/**
 * Author: Alexei Khorunzhyi
 * Date: 19.04.17.
 * Time: 01:03.
 */
@HttpAction("/3/movie/popular")
public class PopularMoviesHttpAction extends PosterHttpAction implements Responsible<List<MovieEntity>> {

    @Response
    MoviesHolder response;

    @Override public List<MovieEntity> response() {
        return response.get();
    }
}
