package khorunzhyicom.alex.theposter.service.interactors


import io.techery.janet.ActionPipe
import io.techery.janet.Janet
import io.techery.janet.ReadActionPipe
import khorunzhyicom.alex.theposter.service.commands.movies.GetPopularMoviesCommand
import khorunzhyicom.alex.theposter.service.commands.ext.createPipe

/**
 * Author: Alexei Khorunzhyi
 * Date: 10.05.17.
 * Date: 20:06.
 */
class PopularMoviesInteractor(janet: Janet) {

    private val popularMoviesPipe: ActionPipe<GetPopularMoviesCommand> = janet.createPipe(GetPopularMoviesCommand::class)

    fun pipe(): ReadActionPipe<GetPopularMoviesCommand> = popularMoviesPipe

    fun requestMovies() = popularMoviesPipe.send(GetPopularMoviesCommand())
}
