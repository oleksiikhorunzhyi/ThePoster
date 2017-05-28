package khorunzhyicom.alex.theposter.presentation.top


import khorunzhyicom.alex.theposter.presentation.activity.adapter.TabView
import khorunzhyicom.alex.theposter.presentation.common.view.ContentView
import khorunzhyicom.alex.theposter.presentation.common.view.PosterBaseView
import khorunzhyicom.alex.theposter.service.models.Movie

interface TopMoviesView : PosterBaseView, TabView, ContentView<List<Movie>>
