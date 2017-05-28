package khorunzhyicom.alex.theposter.presentation.popular

import khorunzhyicom.alex.theposter.presentation.activity.adapter.TabView
import khorunzhyicom.alex.theposter.presentation.common.view.ContentView
import khorunzhyicom.alex.theposter.presentation.common.view.PosterBaseView
import khorunzhyicom.alex.theposter.service.models.Movie

interface PopularMoviesView : PosterBaseView, TabView, ContentView<List<Movie>>
