package khorunzhyicom.alex.theposter.api.service;


import io.techery.janet.ActionHolder;
import io.techery.janet.JanetException;
import io.techery.janet.converter.Converter;
import io.techery.janet.http.HttpClient;
import io.techery.janet.okhttp3.OkClient;
import khorunzhyicom.alex.theposter.api.actions.common.Authorizable;
import khorunzhyicom.alex.theposter.api.auth.AuthData;
import khorunzhyicom.alex.theposter.api.auth.AuthDataProvider;
import khorunzhyicom.alex.theposter.api.config.ConfigData;
import khorunzhyicom.alex.theposter.api.config.ConfigDataProvider;
import khorunzhyicom.alex.theposter.api.converter.PosterGsonConverter;

public class PosterHttpService extends PosterActionServiceWrapper {

    private final AuthDataProvider<AuthData> authDataProvider;

    public PosterHttpService(ConfigDataProvider<ConfigData> configDataProvider, AuthDataProvider<AuthData> authDataProvider, HttpClient httpClient, Converter converter) {
        super(configDataProvider, httpClient, converter);
        this.authDataProvider = authDataProvider;
    }

    public PosterHttpService(ConfigDataProvider<ConfigData> configDataProvider, AuthDataProvider<AuthData> authDataProvider) {
        this(configDataProvider, authDataProvider, new OkClient(), new PosterGsonConverter().provide());
    }

    @Override
    protected <A> boolean onInterceptSend(ActionHolder<A> actionHolder) throws JanetException {
        if (actionHolder.action() instanceof Authorizable) {
            Authorizable action = (Authorizable) actionHolder.action();
            authorizeAction(action);
        }
        return false;
    }

    private void authorizeAction(Authorizable action) {
        if (authDataProvider.provide() == null)
            throw new IllegalArgumentException("Not provided authorize data");
        action.authorize(authDataProvider.provide());
    }
}
