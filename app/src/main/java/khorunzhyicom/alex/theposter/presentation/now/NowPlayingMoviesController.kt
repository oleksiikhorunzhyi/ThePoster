package khorunzhyicom.alex.theposter.presentation.now

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.activity.adapter.TabView
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController
import khorunzhyicom.alex.theposter.presentation.now.NowPlayingMoviesPresenter
import khorunzhyicom.alex.theposter.presentation.now.NowPlayingMoviesView
import khorunzhyicom.alex.theposter.service.models.Movie

class NowPlayingMoviesController : ViewBinderController<NowPlayingMoviesView, NowPlayingMoviesPresenter>(), NowPlayingMoviesView, TabView {

    override fun createPresenter(): NowPlayingMoviesPresenter = NowPlayingMoviesPresenter()

    override fun injector(): PresentationInjector = (applicationContext as App).uiInjector()

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View = inflater.inflate(R.layout.controller_now_movies, container, false)

    override fun updateMovies(movies: List<Movie>) {}

    override fun showError(error: String) {}

    override fun title(): Int = R.string.tab_now

    override fun controller(): NowPlayingMoviesController = this
}
