package khorunzhyicom.alex.theposter.presentation.popular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.activity.adapter.TabView
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController
import khorunzhyicom.alex.theposter.service.models.Movie

class PopularMoviesController : ViewBinderController<PopularMoviesView, PopularMoviesPresenter>(), PopularMoviesView, TabView {

    override fun createPresenter(): PopularMoviesPresenter = PopularMoviesPresenter()

    override fun injector(): PresentationInjector = (applicationContext as App).uiInjector()

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View = inflater.inflate(R.layout.controller_popular_movies, container, false)

    override fun updateMovies(movies: List<Movie>) {}

    override fun showError(error: String) {}

    override fun title(): Int = R.string.tab_popular

    override fun controller(): PopularMoviesController = this
}
