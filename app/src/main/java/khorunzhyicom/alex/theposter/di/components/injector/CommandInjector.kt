package khorunzhyicom.alex.theposter.di.components.injector

import khorunzhyicom.alex.theposter.service.commands.GetNowPlayingMoviesCommand
import khorunzhyicom.alex.theposter.service.commands.GetPopularMoviesCommand
import khorunzhyicom.alex.theposter.service.commands.GetTopMoviesCommand
import khorunzhyicom.alex.theposter.service.commands.GetUpcomingMoviesCommand

interface CommandInjector : Injector {

    fun inject(command: GetPopularMoviesCommand)
    fun inject(command: GetTopMoviesCommand)
    fun inject(command: GetNowPlayingMoviesCommand)
    fun inject(command: GetUpcomingMoviesCommand)
}
