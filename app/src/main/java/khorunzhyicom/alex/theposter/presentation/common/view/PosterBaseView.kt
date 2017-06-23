package khorunzhyicom.alex.theposter.presentation.common.view


import com.hannesdorfmann.mosby3.mvp.MvpView
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.activity.adapter.TabView
import khorunzhyicom.alex.theposter.service.models.Movie

interface PosterBaseView : MvpView, RxView, TabView, ContentView<List<Movie>>, Injectable<PresentationInjector>
