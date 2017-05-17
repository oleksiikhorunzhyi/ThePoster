package khorunzhyicom.alex.theposter.di.components.injector;

import khorunzhyicom.alex.theposter.service.commands.GetPopularMoviesCommand;

public interface CommandInjector extends Injector {

    void inject(GetPopularMoviesCommand command);
}
