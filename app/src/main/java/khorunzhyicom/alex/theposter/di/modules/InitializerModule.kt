package khorunzhyicom.alex.theposter.di.modules

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.core.AppInitializer
import khorunzhyicom.alex.theposter.core.ConfigurationInitializer
import khorunzhyicom.alex.theposter.core.PosterAppInitializer
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScope

@Module class InitializerModule {

    @Provides @ServiceScope @IntoSet fun provideConfigurationInitializer() : AppInitializer = ConfigurationInitializer()

    @Provides @ServiceScope fun providePosterAppInitializer(app: App, initializers: MutableSet<AppInitializer>) : PosterAppInitializer = PosterAppInitializer(app, initializers)

}
