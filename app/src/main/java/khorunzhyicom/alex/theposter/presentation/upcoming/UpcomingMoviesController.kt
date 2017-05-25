package khorunzhyicom.alex.theposter.presentation.upcoming

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.activity.adapter.TabView
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController
import khorunzhyicom.alex.theposter.presentation.now.UpcomingMoviesPresenter
import khorunzhyicom.alex.theposter.presentation.now.UpcomingMoviesView
import khorunzhyicom.alex.theposter.presentation.top.TopMoviesController
import khorunzhyicom.alex.theposter.service.models.Movie

class UpcomingMoviesController : ViewBinderController<UpcomingMoviesView, UpcomingMoviesPresenter>(), UpcomingMoviesView, TabView {

    override fun createPresenter(): UpcomingMoviesPresenter = UpcomingMoviesPresenter()

    override fun injector(): PresentationInjector = (applicationContext as App).uiInjector()

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View = inflater.inflate(R.layout.controller_upcoming_movies, container, false)

    override fun updateMovies(movies: List<Movie>) {}

    override fun showError(error: String) {}

    override fun title(): Int = R.string.tab_upcoming

    override fun controller(): UpcomingMoviesController = this
}
