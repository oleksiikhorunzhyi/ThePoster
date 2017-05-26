package khorunzhyicom.alex.theposter.di.modules

import android.content.Context
import android.content.res.Resources

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import khorunzhyicom.alex.theposter.App

@Module
class AppModule(var app: App) {

    @Provides @Singleton fun provideContext(): Context {
        return app.applicationContext
    }

    @Provides @Singleton fun provideApplication(): App {
        return app
    }

    @Provides @Singleton fun provideResources(): Resources {
        return app.resources
    }
}
