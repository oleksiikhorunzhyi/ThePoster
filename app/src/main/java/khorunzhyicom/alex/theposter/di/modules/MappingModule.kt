package khorunzhyicom.alex.theposter.di.modules

import dagger.Module
import dagger.Provides
import khorunzhyicom.alex.theposter.api.entities.ConfigurationEntity
import khorunzhyicom.alex.theposter.api.entities.MovieEntity
import khorunzhyicom.alex.theposter.service.mappers.ConfigurationMapper
import khorunzhyicom.alex.theposter.service.mappers.Mapper
import khorunzhyicom.alex.theposter.service.mappers.MovieMapper
import khorunzhyicom.alex.theposter.service.mappers.MoviesMapper
import khorunzhyicom.alex.theposter.service.models.Configuration
import khorunzhyicom.alex.theposter.service.models.Movie
import javax.inject.Singleton

@Module class MappingModule {

    @Provides @Singleton fun provideMovieMapper(): Mapper<MovieEntity, Movie> = MovieMapper()

    @Provides @Singleton fun provideConfigurationMapper(): Mapper<ConfigurationEntity, Configuration> = ConfigurationMapper()

    @Provides @Singleton fun provideMoviesMapper(mapper: Mapper<MovieEntity, Movie>): MoviesMapper = MoviesMapper(mapper)
}
