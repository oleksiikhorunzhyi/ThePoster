package khorunzhyicom.alex.theposter.di.modules

import dagger.Module
import dagger.Provides
import io.techery.janet.ActionService
import io.techery.janet.CommandActionService
import io.techery.janet.Janet
import khorunzhyicom.alex.theposter.api.auth.AuthData
import khorunzhyicom.alex.theposter.api.auth.AuthDataProvider
import khorunzhyicom.alex.theposter.api.config.ConfigData
import khorunzhyicom.alex.theposter.api.config.ConfigDataProvider
import khorunzhyicom.alex.theposter.api.service.PosterHttpService
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScope
import khorunzhyicom.alex.theposter.service.common.InjectableCommandActionService

@Module class JanetModule {

    @ServiceScope @Provides fun provideJanet(actionService: ActionService, authDataProvider: AuthDataProvider<AuthData>, configDataProvider: ConfigDataProvider<ConfigData>, context: App): Janet {
        var service = actionService
        return Janet.Builder().apply {
            service = InjectableCommandActionService(service, context)
            addService(PosterHttpService(configDataProvider, authDataProvider))
            addService(service)
        }.build()
    }

    @ServiceScope @Provides fun provideCommandActionService(): ActionService {
        return CommandActionService()
    }
}
