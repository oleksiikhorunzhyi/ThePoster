package khorunzhyicom.alex.theposter.presentation.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.presentation.common.controller.PosterTabController

class UpcomingMoviesController(args: Bundle? = null) : PosterTabController<UpcomingMoviesView, UpcomingMoviesPresenter>(args), UpcomingMoviesView {

    override fun createPresenter(): UpcomingMoviesPresenter = UpcomingMoviesPresenter()

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View = inflater.inflate(R.layout.controller_upcoming_movies, container, false)

    override fun tabTitle() = R.string.tab_upcoming

    override fun tabController(): UpcomingMoviesController = this
}
