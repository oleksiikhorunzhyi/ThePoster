package khorunzhyicom.alex.theposter.di.modules;


import dagger.Module;
import dagger.Provides;
import io.techery.janet.Janet;
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScope;
import khorunzhyicom.alex.theposter.service.interactors.NowPlayingMoviesInteractor;
import khorunzhyicom.alex.theposter.service.interactors.PopularMoviesInteractor;
import khorunzhyicom.alex.theposter.service.interactors.TopMoviesInteractor;
import khorunzhyicom.alex.theposter.service.interactors.UpcomingMoviesInteractor;

@Module
public class ApiModule {

    @ServiceScope
    @Provides
    PopularMoviesInteractor provideMoviesInteractor(Janet janet) {
        return new PopularMoviesInteractor(janet);
    }

    @ServiceScope
    @Provides
    TopMoviesInteractor provideTopMoviesInteractor(Janet janet) {
        return new TopMoviesInteractor(janet);
    }

    @ServiceScope
    @Provides
    NowPlayingMoviesInteractor provideNowPlayingMoviesInteractor(Janet janet) {
        return new NowPlayingMoviesInteractor(janet);
    }

    @ServiceScope
    @Provides
    UpcomingMoviesInteractor provideUpcomingMoviesInteractor(Janet janet) {
        return new UpcomingMoviesInteractor(janet);
    }

}
