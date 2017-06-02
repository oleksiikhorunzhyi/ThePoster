package khorunzhyicom.alex.theposter.di.modules


import dagger.Module
import dagger.Provides
import io.techery.janet.Janet
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScope
import khorunzhyicom.alex.theposter.service.interactors.*

@Module class InteractorsModule {

    @Provides @ServiceScope fun provideMoviesInteractor(janet: Janet): PopularMoviesInteractor {
        return PopularMoviesInteractor(janet)
    }

    @Provides @ServiceScope fun provideTopMoviesInteractor(janet: Janet): TopMoviesInteractor {
        return TopMoviesInteractor(janet)
    }

    @Provides @ServiceScope fun provideNowPlayingMoviesInteractor(janet: Janet): NowPlayingMoviesInteractor {
        return NowPlayingMoviesInteractor(janet)
    }

    @Provides @ServiceScope fun provideUpcomingMoviesInteractor(janet: Janet): UpcomingMoviesInteractor {
        return UpcomingMoviesInteractor(janet)
    }

    @Provides @ServiceScope fun provideConfigurationInteractor(janet: Janet): ConfigurationInteractor {
        return ConfigurationInteractor(janet)
    }

}
