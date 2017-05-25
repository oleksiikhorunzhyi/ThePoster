package khorunzhyicom.alex.theposter.presentation.top

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.activity.adapter.TabView
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController
import khorunzhyicom.alex.theposter.service.models.Movie

class TopMoviesController : ViewBinderController<TopMoviesView, TopMoviesPresenter>(), TopMoviesView, TabView {

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_top_movies, container, false)
    }

    override fun createPresenter(): TopMoviesPresenter =  TopMoviesPresenter()

    override fun injector(): PresentationInjector = (applicationContext as App).uiInjector()

    override fun title(): Int = R.string.tab_top

    override fun controller(): TopMoviesController = this

    override fun updateMovies(movies: List<Movie>) {}

    override fun showError(error: String) {}

}
