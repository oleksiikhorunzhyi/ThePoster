package khorunzhyicom.alex.theposter.di.modules;


import dagger.Module;
import dagger.Provides;
import io.techery.janet.Janet;
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScoup;
import khorunzhyicom.alex.theposter.service.interactors.MoviesInteractor;

@Module
public class ApiModule {

    @ServiceScoup
    @Provides
    MoviesInteractor provideMoviesInteractor(Janet janet) {
        return new MoviesInteractor(janet);
    }
}
