package khorunzhyicom.alex.theposter.service.commands.movies

import io.techery.janet.Janet
import io.techery.janet.command.annotations.CommandAction
import khorunzhyicom.alex.theposter.api.actions.movies.TopRatedMoviesHttpAction
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.service.commands.base.ApiCommand
import khorunzhyicom.alex.theposter.service.commands.ext.composeWithConfiguration
import khorunzhyicom.alex.theposter.service.commands.ext.createPipe
import khorunzhyicom.alex.theposter.service.commands.ext.transformWith
import khorunzhyicom.alex.theposter.service.mappers.MoviesMapper
import khorunzhyicom.alex.theposter.service.models.Configuration
import khorunzhyicom.alex.theposter.service.models.Movie
import khorunzhyicom.alex.theposter.service.providers.StreamProvider
import javax.inject.Inject

@CommandAction
class GetUpcomingMoviesCommand : ApiCommand<List<Movie>>() {

    @Inject lateinit var janet: Janet
    @Inject lateinit var mapper: MoviesMapper
    @Inject lateinit var configProvider: StreamProvider<Configuration>

    override fun injectTo(component: CommandInjector) = component.inject(this)

    @Throws(Throwable::class)
    override fun run(callback: CommandCallback<List<Movie>>) {
        janet.createPipe(TopRatedMoviesHttpAction::class)
                .createObservableResult(TopRatedMoviesHttpAction())
                .transformWith({ mapper.map(it) })
                .composeWithConfiguration(configProvider.provide())
                .subscribe({ callback.onSuccess(it) }, { callback.onFail(it) })
    }
}
