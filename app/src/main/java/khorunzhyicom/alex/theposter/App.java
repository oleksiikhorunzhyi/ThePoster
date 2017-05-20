package khorunzhyicom.alex.theposter;

import android.app.Application;
import android.support.annotation.NonNull;

import khorunzhyicom.alex.theposter.di.components.ApiComponent;
import khorunzhyicom.alex.theposter.di.components.AppComponent;
import khorunzhyicom.alex.theposter.di.components.DaggerAppComponent;
import khorunzhyicom.alex.theposter.di.modules.ApiModule;
import khorunzhyicom.alex.theposter.di.modules.AppModule;

public class App extends Application {

    protected AppComponent appComponent;
    protected ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        this.apiComponent = appComponent.plus(new ApiModule());
        this.appComponent.inject(this);
    }

    @NonNull
    public ApiComponent apiComponent() {
        return apiComponent;
    }
}
