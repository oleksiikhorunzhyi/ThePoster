package khorunzhyicom.alex.theposter.di.modules;

import dagger.Module;
import dagger.Provides;
import khorunzhyicom.alex.theposter.api.entities.MovieEntity;
import khorunzhyicom.alex.theposter.service.mappers.Mapper;
import khorunzhyicom.alex.theposter.service.mappers.MovieMapper;
import khorunzhyicom.alex.theposter.service.mappers.MoviesMapper;
import khorunzhyicom.alex.theposter.service.models.Movie;

@Module
public class MappingModule {

    @Provides
    Mapper<MovieEntity, Movie> provideMovieMapper() {
        return new MovieMapper();
    }

    @Provides
    MoviesMapper provideMoviesMapper(Mapper<MovieEntity, Movie> mapper) {
        return new MoviesMapper(mapper);
    }
}
