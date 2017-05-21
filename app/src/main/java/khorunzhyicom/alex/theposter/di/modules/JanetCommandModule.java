package khorunzhyicom.alex.theposter.di.modules;

import dagger.Module;
import dagger.Provides;
import io.techery.janet.ActionService;
import io.techery.janet.CommandActionService;
import io.techery.janet.Janet;
import khorunzhyicom.alex.theposter.api.auth.AuthData;
import khorunzhyicom.alex.theposter.api.auth.AuthDataProvider;
import khorunzhyicom.alex.theposter.api.config.ConfigData;
import khorunzhyicom.alex.theposter.api.config.ConfigDataProvider;
import khorunzhyicom.alex.theposter.api.service.PosterHttpService;
import khorunzhyicom.alex.theposter.App;
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScope;
import khorunzhyicom.alex.theposter.service.common.InjectableCommandActionService;

@Module
public class JanetCommandModule {

    @ServiceScope
    @Provides
    Janet provideJanet(ActionService service, AuthDataProvider<AuthData> authDataProvider, ConfigDataProvider<ConfigData> configDataProvider, App context) {
        Janet.Builder builder = new Janet.Builder();
        service = new InjectableCommandActionService(service, context);
        builder.addService(new PosterHttpService(configDataProvider, authDataProvider));
        builder.addService(service);
        return builder.build();
    }

    @ServiceScope
    @Provides
    ActionService provideCommandActionService() {
        return new CommandActionService();
    }
}
