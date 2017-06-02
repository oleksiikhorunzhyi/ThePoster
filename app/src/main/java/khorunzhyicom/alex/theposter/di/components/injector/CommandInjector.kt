package khorunzhyicom.alex.theposter.di.components.injector

import khorunzhyicom.alex.theposter.service.commands.configuration.GetConfigurationCommand
import khorunzhyicom.alex.theposter.service.commands.movies.GetNowPlayingMoviesCommand
import khorunzhyicom.alex.theposter.service.commands.movies.GetPopularMoviesCommand
import khorunzhyicom.alex.theposter.service.commands.movies.GetTopMoviesCommand
import khorunzhyicom.alex.theposter.service.commands.movies.GetUpcomingMoviesCommand

interface CommandInjector : Injector {

    fun inject(command: GetPopularMoviesCommand)
    fun inject(command: GetTopMoviesCommand)
    fun inject(command: GetNowPlayingMoviesCommand)
    fun inject(command: GetUpcomingMoviesCommand)
    fun inject(command: GetConfigurationCommand)
}
