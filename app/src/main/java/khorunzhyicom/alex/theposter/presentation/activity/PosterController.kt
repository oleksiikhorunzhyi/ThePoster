package khorunzhyicom.alex.theposter.presentation.activity


import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import findView
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.activity.adapter.PosterTabLayout
import khorunzhyicom.alex.theposter.presentation.activity.adapter.PosterTabsAdapter
import khorunzhyicom.alex.theposter.presentation.activity.adapter.TabView
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController
import khorunzhyicom.alex.theposter.presentation.now.NowPlayingMoviesController
import khorunzhyicom.alex.theposter.presentation.popular.PopularMoviesController
import khorunzhyicom.alex.theposter.presentation.top.TopMoviesController
import khorunzhyicom.alex.theposter.presentation.upcoming.UpcomingMoviesController

class PosterController : ViewBinderController<PosterView, PosterPresenter>, PosterView {

    constructor() : this(null)
    constructor(args: Bundle?) : super(args)

    val pager: ViewPager by findView<ViewPager>(R.id.poster_view_pager)
    val tabs: List<TabView> = tabs()

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_poster_home, container, false)
    }

    override fun createPresenter(): PosterPresenter {
        return PosterPresenter()
    }

    override fun injector(): PresentationInjector = (applicationContext as App).uiInjector()

    override fun onAttach(view: View) {
        super.onAttach(view)
        pager.adapter = PosterTabsAdapter(this, view.context, tabs)
        pager.offscreenPageLimit = tabs.size
        (activity!!.findViewById(R.id.poster_tab_layout) as PosterTabLayout).setViewPager(pager)
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        pager.adapter = null
    }

    fun tabs(): List<TabView> {
        return listOf(NowPlayingMoviesController(),
                PopularMoviesController(),
                TopMoviesController(),
                UpcomingMoviesController())
    }
}
