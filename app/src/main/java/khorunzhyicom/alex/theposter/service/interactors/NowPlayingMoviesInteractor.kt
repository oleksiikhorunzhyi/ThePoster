package khorunzhyicom.alex.theposter.service.interactors

import io.techery.janet.ActionPipe
import io.techery.janet.Janet
import io.techery.janet.ReadActionPipe
import khorunzhyicom.alex.theposter.service.commands.GetNowPlayingMoviesCommand
import khorunzhyicom.alex.theposter.service.commands.ext.createPipe


class NowPlayingMoviesInteractor(janet: Janet) {

    private val nowPlayingMoviesPipe: ActionPipe<GetNowPlayingMoviesCommand> = janet.createPipe(GetNowPlayingMoviesCommand::class)

    fun nowPlayingMoviesPipe(): ReadActionPipe<GetNowPlayingMoviesCommand> = nowPlayingMoviesPipe

    fun requestnowPlayingMovies() = nowPlayingMoviesPipe.send(GetNowPlayingMoviesCommand())
}
