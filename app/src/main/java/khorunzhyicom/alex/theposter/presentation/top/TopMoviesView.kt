package khorunzhyicom.alex.theposter.presentation.top


import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.common.view.DaggerView
import khorunzhyicom.alex.theposter.presentation.common.view.PosterView
import khorunzhyicom.alex.theposter.service.models.Movie

interface TopMoviesView : PosterView, DaggerView<PresentationInjector> {

    fun updateMovies(movies: List<Movie>)

    fun showError(error: String)
}