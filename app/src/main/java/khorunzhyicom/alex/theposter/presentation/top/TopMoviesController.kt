package khorunzhyicom.alex.theposter.presentation.top

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController

class TopMoviesController : ViewBinderController<TopMoviesView, TopMoviesPresenter>(), TopMoviesView {

    override fun inflateView(layoutInflater: LayoutInflater, viewGroup: ViewGroup): View {
        return layoutInflater.inflate(R.layout.controller_top_movies, viewGroup, false)
    }

    override fun createPresenter(): TopMoviesPresenter {
        return TopMoviesPresenter()
    }

    override fun injector(): PresentationInjector {
        return (applicationContext as App).uiComponent()
    }
}
