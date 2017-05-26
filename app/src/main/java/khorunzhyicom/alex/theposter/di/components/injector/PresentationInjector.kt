package khorunzhyicom.alex.theposter.di.components.injector

import khorunzhyicom.alex.theposter.presentation.activity.PosterActivity
import khorunzhyicom.alex.theposter.presentation.now.NowPlayingMoviesPresenter
import khorunzhyicom.alex.theposter.presentation.now.UpcomingMoviesPresenter
import khorunzhyicom.alex.theposter.presentation.popular.PopularMoviesPresenter
import khorunzhyicom.alex.theposter.presentation.top.TopMoviesPresenter

interface PresentationInjector : Injector {

    fun inject(presenter: PopularMoviesPresenter)
    fun inject(presenter: TopMoviesPresenter)
    fun inject(presenter: UpcomingMoviesPresenter)
    fun inject(presenter: NowPlayingMoviesPresenter)

    fun inject(activity: PosterActivity)
}
