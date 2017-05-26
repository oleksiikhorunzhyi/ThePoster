package khorunzhyicom.alex.theposter.di.modules


import dagger.Module
import dagger.Provides
import io.techery.janet.Janet
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScope
import khorunzhyicom.alex.theposter.service.interactors.NowPlayingMoviesInteractor
import khorunzhyicom.alex.theposter.service.interactors.PopularMoviesInteractor
import khorunzhyicom.alex.theposter.service.interactors.TopMoviesInteractor
import khorunzhyicom.alex.theposter.service.interactors.UpcomingMoviesInteractor

@Module class ApiModule {

    @ServiceScope @Provides fun provideMoviesInteractor(janet: Janet): PopularMoviesInteractor {
        return PopularMoviesInteractor(janet)
    }

    @ServiceScope @Provides fun provideTopMoviesInteractor(janet: Janet): TopMoviesInteractor {
        return TopMoviesInteractor(janet)
    }

    @ServiceScope @Provides fun provideNowPlayingMoviesInteractor(janet: Janet): NowPlayingMoviesInteractor {
        return NowPlayingMoviesInteractor(janet)
    }

    @ServiceScope @Provides fun provideUpcomingMoviesInteractor(janet: Janet): UpcomingMoviesInteractor {
        return UpcomingMoviesInteractor(janet)
    }

}
