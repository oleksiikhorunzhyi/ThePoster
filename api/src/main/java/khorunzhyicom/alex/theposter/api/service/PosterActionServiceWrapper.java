package khorunzhyicom.alex.theposter.api.service;

import io.techery.janet.ActionHolder;
import io.techery.janet.ActionServiceWrapper;
import io.techery.janet.HttpActionService;
import io.techery.janet.JanetException;
import io.techery.janet.converter.Converter;
import io.techery.janet.http.HttpClient;
import khorunzhyicom.alex.theposter.api.config.ConfigData;
import khorunzhyicom.alex.theposter.api.config.ConfigDataProvider;

public abstract class PosterActionServiceWrapper extends ActionServiceWrapper {

    public PosterActionServiceWrapper(ConfigDataProvider<ConfigData> configDataProvider, HttpClient httpClient, Converter converter) {
        super(new HttpActionService(configDataProvider.provide().url(), httpClient, converter));
    }

    @Override
    protected <A> boolean onInterceptSend(ActionHolder<A> actionHolder) throws JanetException {
        return false;
    }

    @Override
    protected <A> void onInterceptCancel(ActionHolder<A> actionHolder) {

    }

    @Override
    protected <A> void onInterceptStart(ActionHolder<A> actionHolder) {

    }

    @Override
    protected <A> void onInterceptProgress(ActionHolder<A> actionHolder, int i) {

    }

    @Override
    protected <A> void onInterceptSuccess(ActionHolder<A> actionHolder) {

    }

    @Override
    protected <A> boolean onInterceptFail(ActionHolder<A> actionHolder, JanetException e) {
        return false;
    }
}
