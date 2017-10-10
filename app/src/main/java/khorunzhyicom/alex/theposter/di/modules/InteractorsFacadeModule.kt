package khorunzhyicom.alex.theposter.di.modules

import dagger.Module
import dagger.Provides
import khorunzhyicom.alex.theposter.service.interactors.ConfigurationInteractor
import khorunzhyicom.alex.theposter.service.models.Configuration
import khorunzhyicom.alex.theposter.service.providers.ConfigurationProvider
import khorunzhyicom.alex.theposter.service.providers.StreamProvider
import javax.inject.Singleton


@Module class InteractorsFacadeModule {

    @Singleton @Provides fun provideConfigurationProvider(configInteractor: ConfigurationInteractor) : StreamProvider<Configuration> {
        return ConfigurationProvider(configInteractor)
    }
}