package khorunzhyicom.alex.theposter.service.commands

import io.techery.janet.Command
import io.techery.janet.Janet
import io.techery.janet.command.annotations.CommandAction
import khorunzhyicom.alex.theposter.api.actions.NowPlayingMoviesHttpAction
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.service.commands.base.ApiCommand
import khorunzhyicom.alex.theposter.service.commands.ext.createPipe
import khorunzhyicom.alex.theposter.service.commands.ext.transformWith
import khorunzhyicom.alex.theposter.service.mappers.MoviesMapper
import khorunzhyicom.alex.theposter.service.models.Movie
import javax.inject.Inject

@CommandAction
class GetNowPlayingMoviesCommand : ApiCommand<List<Movie>>() {

    @Inject lateinit var janet: Janet
    @Inject lateinit var mapper: MoviesMapper

    override fun injectTo(component: CommandInjector) {
        component.inject(this)
    }

    @Throws(Throwable::class)
    override fun run(callback: Command.CommandCallback<List<Movie>>) {
        janet.createPipe(NowPlayingMoviesHttpAction::class)
                .createObservableResult(NowPlayingMoviesHttpAction())
                .transformWith({ mapper.map(it) })
                .subscribe({ callback.onSuccess(it) }, { callback.onFail(it) })
    }
}
