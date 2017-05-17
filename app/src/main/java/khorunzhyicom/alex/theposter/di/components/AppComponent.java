package khorunzhyicom.alex.theposter.di.components;

import javax.inject.Singleton;

import dagger.Component;
import khorunzhyicom.alex.theposter.di.components.injector.AppInjector;
import khorunzhyicom.alex.theposter.di.modules.ApiModule;
import khorunzhyicom.alex.theposter.di.modules.AppModule;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent extends AppInjector, ContextProvider {

    ApiComponent plus(ApiModule apiModule);
}
