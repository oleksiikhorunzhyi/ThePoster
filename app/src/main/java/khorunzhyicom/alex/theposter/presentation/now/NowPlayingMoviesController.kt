package khorunzhyicom.alex.theposter.presentation.now

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.presentation.common.controller.PosterTabController

class NowPlayingMoviesController(args: Bundle? = null) : PosterTabController<NowPlayingMoviesView, NowPlayingMoviesPresenter>(args), NowPlayingMoviesView {

    override fun createPresenter(): NowPlayingMoviesPresenter = NowPlayingMoviesPresenter()

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View = inflater.inflate(R.layout.controller_now_movies, container, false)

    override fun tabTitle(): Int = R.string.tab_now

    override fun tabController(): NowPlayingMoviesController = this
}
