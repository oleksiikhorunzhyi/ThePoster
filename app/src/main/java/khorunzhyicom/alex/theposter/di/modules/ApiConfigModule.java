package khorunzhyicom.alex.theposter.di.modules;

import dagger.Module;
import dagger.Provides;
import khorunzhyicom.alex.theposter.api.auth.AuthData;
import khorunzhyicom.alex.theposter.api.auth.AuthDataProvider;
import khorunzhyicom.alex.theposter.api.auth.ImmutableAuthData;
import khorunzhyicom.alex.theposter.api.auth.ImmutableAuthDataProvider;
import khorunzhyicom.alex.theposter.api.config.ConfigData;
import khorunzhyicom.alex.theposter.api.config.ConfigDataProvider;
import khorunzhyicom.alex.theposter.api.config.ImmutableConfigData;
import khorunzhyicom.alex.theposter.api.config.ImmutableConfigDataProvider;
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScope;

@Module
public class ApiConfigModule {

    @ServiceScope
    @Provides
    AuthDataProvider<AuthData> provideAuthDataProvider() {
        return ImmutableAuthDataProvider.builder().provide(ImmutableAuthData.builder()
                .token("c4b8ea2605abcab92ec0ca2c0d9b864e")
                .build()).build();
    }

    @ServiceScope
    @Provides
    ConfigDataProvider<ConfigData> provideConfigDataProvider() {
        return ImmutableConfigDataProvider.builder().provide(ImmutableConfigData.builder()
                .url("https://api.themoviedb.org/")
                .build()).build();
    }
}
