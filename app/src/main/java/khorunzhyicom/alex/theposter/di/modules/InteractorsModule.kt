package khorunzhyicom.alex.theposter.di.modules


import dagger.Module
import dagger.Provides
import io.techery.janet.Janet
import khorunzhyicom.alex.theposter.service.interactors.*
import javax.inject.Singleton

@Module class InteractorsModule {

    @Provides @Singleton fun provideMoviesInteractor(janet: Janet): PopularMoviesInteractor {
        return PopularMoviesInteractor(janet)
    }

    @Provides @Singleton fun provideTopMoviesInteractor(janet: Janet): TopMoviesInteractor {
        return TopMoviesInteractor(janet)
    }

    @Provides @Singleton fun provideNowPlayingMoviesInteractor(janet: Janet): NowPlayingMoviesInteractor {
        return NowPlayingMoviesInteractor(janet)
    }

    @Provides @Singleton fun provideUpcomingMoviesInteractor(janet: Janet): UpcomingMoviesInteractor {
        return UpcomingMoviesInteractor(janet)
    }

    @Provides @Singleton fun provideConfigurationInteractor(janet: Janet): ConfigurationInteractor {
        return ConfigurationInteractor(janet)
    }

}
