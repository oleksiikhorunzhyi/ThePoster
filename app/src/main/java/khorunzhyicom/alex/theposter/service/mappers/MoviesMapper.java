package khorunzhyicom.alex.theposter.service.mappers;

import khorunzhyicom.alex.theposter.api.entities.MovieEntity;
import khorunzhyicom.alex.theposter.service.models.Movie;

/**
 * Author: Alexei Khorunzhyi
 * Date: 10.05.17.
 * Date: 20:06.
 */
public class MoviesMapper extends ListMapper<MovieEntity, Movie> {

    public MoviesMapper(Mapper<MovieEntity, Movie> mapper) {
        super(mapper);
    }
}
