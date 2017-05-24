package khorunzhyicom.alex.theposter.di.components.injector;

import khorunzhyicom.alex.theposter.service.commands.GetNowPlayingMoviesCommand;
import khorunzhyicom.alex.theposter.service.commands.GetPopularMoviesCommand;
import khorunzhyicom.alex.theposter.service.commands.GetTopMoviesCommand;
import khorunzhyicom.alex.theposter.service.commands.GetUpcomingMoviesCommand;

public interface CommandInjector extends Injector {

    void inject(GetPopularMoviesCommand command);
    void inject(GetTopMoviesCommand command);
    void inject(GetNowPlayingMoviesCommand command);
    void inject(GetUpcomingMoviesCommand command);
}
