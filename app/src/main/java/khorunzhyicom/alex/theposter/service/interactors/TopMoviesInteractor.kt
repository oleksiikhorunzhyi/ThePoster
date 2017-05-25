package khorunzhyicom.alex.theposter.service.interactors


import io.techery.janet.ActionPipe
import io.techery.janet.Janet
import io.techery.janet.ReadActionPipe
import khorunzhyicom.alex.theposter.service.commands.GetTopMoviesCommand
import khorunzhyicom.alex.theposter.service.commands.ext.createPipe

/**
 * Author: Alexei Khorunzhyi
 * Date: 10.05.17.
 * Date: 20:06.
 */
class TopMoviesInteractor(janet: Janet) {

    private val topMoviesPipe: ActionPipe<GetTopMoviesCommand> = janet.createPipe(GetTopMoviesCommand::class)

    fun pipe(): ReadActionPipe<GetTopMoviesCommand> = topMoviesPipe

    fun requestMovies() = topMoviesPipe.send(GetTopMoviesCommand())
}
