package khorunzhyicom.alex.theposter.presentation.common.view


import com.hannesdorfmann.mosby3.mvp.MvpView
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector

interface PosterBaseView : MvpView, RxView, Injectable<PresentationInjector>
