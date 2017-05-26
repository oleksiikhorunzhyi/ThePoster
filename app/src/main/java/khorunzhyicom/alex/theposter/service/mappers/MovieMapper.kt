package khorunzhyicom.alex.theposter.service.mappers

import khorunzhyicom.alex.theposter.api.entities.MovieEntity
import khorunzhyicom.alex.theposter.service.models.Movie

class MovieMapper : Mapper<MovieEntity, Movie> {

    override fun map(entity: MovieEntity): Movie {
        return Movie(
                entity.title(),
                entity.originalTitle(),
                entity.releaseDate(),
                entity.budget(),
                entity.voteCount(),
                entity.voteAverage(),
                entity.popularity(),
                entity.backdropPath(),
                entity.overview(),
                entity.posterPath())
    }
}
