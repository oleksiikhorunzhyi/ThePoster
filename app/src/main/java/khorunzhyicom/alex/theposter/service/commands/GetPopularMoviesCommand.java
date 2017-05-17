package khorunzhyicom.alex.theposter.service.commands;

import java.util.List;

import javax.inject.Inject;

import io.techery.janet.Command;
import io.techery.janet.Janet;
import io.techery.janet.command.annotations.CommandAction;
import khorunzhyicom.alex.theposter.api.actions.PopularMoviesHttpAction;
import khorunzhyicom.alex.theposter.di.components.ApiComponent;
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector;
import khorunzhyicom.alex.theposter.service.mappers.MovieMapper;
import khorunzhyicom.alex.theposter.service.mappers.MoviesMapper;
import khorunzhyicom.alex.theposter.service.models.Movie;
import rx.schedulers.Schedulers;

@CommandAction
public class GetPopularMoviesCommand extends Command<List<Movie>> implements InjectableCommand {

    @Inject Janet janet;
    @Inject MoviesMapper mapper;

    @Override
    public void injectTo(CommandInjector component) {
        component.inject(this);
    }

    @Override
    protected void run(CommandCallback<List<Movie>> callback) throws Throwable {
        janet.createPipe(PopularMoviesHttpAction.class, Schedulers.io())
                .createObservableResult(new PopularMoviesHttpAction())
                .map(PopularMoviesHttpAction::response)
                .map(mapper)
                .subscribe(callback::onSuccess, callback::onFail);
    }
}
