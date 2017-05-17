package khorunzhyicom.alex.theposter.di.components.injector;


import khorunzhyicom.alex.theposter.application.App;

public interface AppInjector extends Injector {

    void inject(App app);
}
