package khorunzhyicom.alex.theposter.di.modules

import dagger.Module
import dagger.Provides
import khorunzhyicom.alex.theposter.api.entities.MovieEntity
import khorunzhyicom.alex.theposter.service.mappers.Mapper
import khorunzhyicom.alex.theposter.service.mappers.MovieMapper
import khorunzhyicom.alex.theposter.service.mappers.MoviesMapper
import khorunzhyicom.alex.theposter.service.models.Movie

@Module class MappingModule {

    @Provides fun provideMovieMapper(): Mapper<MovieEntity, Movie> {
        return MovieMapper()
    }

    @Provides fun provideMoviesMapper(mapper: Mapper<MovieEntity, Movie>): MoviesMapper {
        return MoviesMapper(mapper)
    }
}
