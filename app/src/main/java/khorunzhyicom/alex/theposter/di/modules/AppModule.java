package khorunzhyicom.alex.theposter.di.modules;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import khorunzhyicom.alex.theposter.App;

@Module
public class AppModule {

    protected App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides @Singleton Context provideContext() {
        return app.getApplicationContext();
    }

    @Provides @Singleton App provideApplication() {
        return app;
    }

    @Provides @Singleton Resources provideResources() {
        return app.getResources();
    }
}
