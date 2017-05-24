package khorunzhyicom.alex.theposter.service.interactors

import io.techery.janet.ActionPipe
import io.techery.janet.Janet
import io.techery.janet.ReadActionPipe
import khorunzhyicom.alex.theposter.service.commands.GetUpcomingMoviesCommand
import khorunzhyicom.alex.theposter.service.commands.ext.createPipe

class UpcomingMoviesInteractor(janet: Janet) {

    private val upcomingMoviesPipe: ActionPipe<GetUpcomingMoviesCommand> = janet.createPipe(GetUpcomingMoviesCommand::class)

    fun upcomingMoviesPipe(): ReadActionPipe<GetUpcomingMoviesCommand> = upcomingMoviesPipe

    fun requestUpcomingMovies() = upcomingMoviesPipe.send(GetUpcomingMoviesCommand())
}
