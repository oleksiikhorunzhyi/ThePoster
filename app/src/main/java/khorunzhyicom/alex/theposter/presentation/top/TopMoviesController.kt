package khorunzhyicom.alex.theposter.presentation.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.presentation.common.controller.PosterTabController
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController

class TopMoviesController(args: Bundle? = null) : PosterTabController<TopMoviesView, TopMoviesPresenter>(args), TopMoviesView {

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_top_movies, container, false)
    }

    override fun createPresenter(): TopMoviesPresenter =  TopMoviesPresenter()

    override fun tabTitle(): Int = R.string.tab_top

    override fun tabController(): TopMoviesController = this

}
