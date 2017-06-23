package khorunzhyicom.alex.theposter.presentation.common.view

import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.activity.adapter.TabView
import khorunzhyicom.alex.theposter.service.models.Movie

interface PosterTabView : PosterBaseView, TabView, ContentView<List<Movie>>, Injectable<PresentationInjector> {
}