package khorunzhyicom.alex.theposter.presentation.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.presentation.common.controller.PosterTabController

class PopularMoviesController(args: Bundle? = null) : PosterTabController<PopularMoviesView, PopularMoviesPresenter>(args), PopularMoviesView {

    override fun createPresenter(): PopularMoviesPresenter = PopularMoviesPresenter()

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup) = inflater.inflate(R.layout.controller_popular_movies, container, false)

    override fun tabTitle(): Int = R.string.tab_popular

    override fun tabController(): PopularMoviesController = this
}
