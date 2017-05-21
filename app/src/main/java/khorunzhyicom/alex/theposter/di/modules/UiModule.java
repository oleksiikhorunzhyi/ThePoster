package khorunzhyicom.alex.theposter.di.modules;


import dagger.Module;
import dagger.Provides;
import khorunzhyicom.alex.theposter.di.scoupes.UIScope;
import khorunzhyicom.alex.theposter.presentation.activity.common.PosterDrawerInitializer;

@UIScope
@Module
public class UiModule {

    @UIScope @Provides
    PosterDrawerInitializer posterActivityInitializer() {
        return new PosterDrawerInitializer();
    }
}
