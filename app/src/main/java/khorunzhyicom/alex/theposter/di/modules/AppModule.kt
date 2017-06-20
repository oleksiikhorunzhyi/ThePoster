package khorunzhyicom.alex.theposter.di.modules

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import khorunzhyicom.alex.theposter.App
import javax.inject.Singleton

@Module
class AppModule(var app: App) {

    //@Provides @Singleton fun provideContext(): Context = app.applicationContext

    //@Provides @Singleton fun provideResources(): Resources = app.resources
}
