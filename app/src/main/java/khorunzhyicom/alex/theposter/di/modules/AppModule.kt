package khorunzhyicom.alex.theposter.di.modules

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.core.ApplicationDelegate
import khorunzhyicom.alex.theposter.core.PosterAppInitializer
import khorunzhyicom.alex.theposter.core.PosterApplicationDelegate
import javax.inject.Singleton

@Module
class AppModule(var app: App) {

    @Provides @Singleton fun provideContext(): Context = app.applicationContext

    @Provides @Singleton fun provideApplication(): App = app

    @Provides @Singleton fun provideResources(): Resources = app.resources

    @Provides @Singleton fun provideApplicationDelegate(): PosterApplicationDelegate = PosterApplicationDelegate()
}
