package khorunzhyicom.alex.theposter.presentation.popular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController
import khorunzhyicom.alex.theposter.service.models.Movie

class PopularMoviesController : ViewBinderController<PopularMoviesView, PopularMoviesPresenter>(), PopularMoviesView {

    override fun createPresenter(): PopularMoviesPresenter = PopularMoviesPresenter()

    override fun injector(): PresentationInjector = (applicationContext as App).uiComponent()

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View = inflater.inflate(R.layout.controller_popular_movies, container, false)

    override fun updateMovies(movies: List<Movie>) {}

    override fun showError(error: String) {}
}
