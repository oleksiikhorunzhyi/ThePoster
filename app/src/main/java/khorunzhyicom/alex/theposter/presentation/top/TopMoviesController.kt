package khorunzhyicom.alex.theposter.presentation.top

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController
import khorunzhyicom.alex.theposter.presentation.common.view.DaggerView
import khorunzhyicom.alex.theposter.presentation.common.view.PosterView

class TopMoviesController : ViewBinderController<TopMoviesView, TopMoviesPresenter>(), PosterView, DaggerView<PresentationInjector> {

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_top_movies, container, false)
    }

    override fun createPresenter(): TopMoviesPresenter {
        return TopMoviesPresenter()
    }

    override fun injector(): PresentationInjector {
        return (applicationContext as App).uiComponent()
    }
}
