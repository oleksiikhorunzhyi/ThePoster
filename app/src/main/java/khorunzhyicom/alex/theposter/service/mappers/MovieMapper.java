package khorunzhyicom.alex.theposter.service.mappers;

import khorunzhyicom.alex.theposter.api.entities.MovieEntity;
import khorunzhyicom.alex.theposter.service.models.ImmutableMovie;
import khorunzhyicom.alex.theposter.service.models.Movie;

public class MovieMapper implements Mapper<MovieEntity, Movie> {

    @Override public Movie map(MovieEntity entity) {
        return ImmutableMovie.builder()
                .title(entity.title())
                .originalTitle(entity.originalTitle())
                .voteCount(entity.voteCount())
                .budget(entity.budget())
                .voteAverage(entity.voteAverage())
                .popularity(entity.popularity())
                .backdropPath(entity.backdropPath())
                .overview(entity.overview())
                .posterPath(entity.posterPath())
                .releaseDate(entity.releaseDate())
                .build();
    }
}
