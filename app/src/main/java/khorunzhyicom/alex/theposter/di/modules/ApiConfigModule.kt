package khorunzhyicom.alex.theposter.di.modules

import dagger.Module
import dagger.Provides
import khorunzhyicom.alex.theposter.api.auth.AuthData
import khorunzhyicom.alex.theposter.api.auth.AuthDataProvider
import khorunzhyicom.alex.theposter.api.auth.ImmutableAuthData
import khorunzhyicom.alex.theposter.api.auth.ImmutableAuthDataProvider
import khorunzhyicom.alex.theposter.api.config.ConfigData
import khorunzhyicom.alex.theposter.api.config.ConfigDataProvider
import khorunzhyicom.alex.theposter.api.config.ImmutableConfigData
import khorunzhyicom.alex.theposter.api.config.ImmutableConfigDataProvider
import javax.inject.Singleton

@Module class ApiConfigModule {

    @Singleton @Provides fun provideAuthDataProvider(): AuthDataProvider<AuthData> {
        return ImmutableAuthDataProvider.builder<AuthData>().provide(ImmutableAuthData.builder()
                .token("c4b8ea2605abcab92ec0ca2c0d9b864e")
                .build()).build()
    }

    @Singleton @Provides fun provideConfigDataProvider(): ConfigDataProvider<ConfigData> {
        return ImmutableConfigDataProvider.builder<ConfigData>().provide(ImmutableConfigData.builder()
                .url("https://api.themoviedb.org/")
                .build()).build()
    }
}
