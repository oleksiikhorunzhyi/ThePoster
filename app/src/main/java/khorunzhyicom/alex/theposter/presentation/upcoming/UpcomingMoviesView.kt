package khorunzhyicom.alex.theposter.presentation.upcoming

import khorunzhyicom.alex.theposter.presentation.activity.adapter.TabView
import khorunzhyicom.alex.theposter.presentation.common.view.ContentView
import khorunzhyicom.alex.theposter.presentation.common.view.PosterBaseView
import khorunzhyicom.alex.theposter.service.models.Movie

interface UpcomingMoviesView : PosterBaseView, TabView, ContentView<List<Movie>>
