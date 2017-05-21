package khorunzhyicom.alex.theposter.presentation.activity


import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import findView
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.presentation.activity.adapter.PosterTabLayout
import khorunzhyicom.alex.theposter.presentation.activity.adapter.PosterTabsAdapter
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController
import khorunzhyicom.alex.theposter.presentation.popular.PopularMoviesController
import khorunzhyicom.alex.theposter.presentation.top.TopMoviesController
import java.util.*

class PosterController : ViewBinderController<PosterView, PosterPresenter>, PosterView {

    constructor() : this(null)
    constructor(args: Bundle?) : super(args)

    val pager: ViewPager by findView<ViewPager>(R.id.poster_view_pager)
    val adapter = PosterTabsAdapter(this, Arrays.asList(TopMoviesController(), PopularMoviesController()))

    override fun onViewBound(view: View) {
        pager.adapter = adapter
        (activity!!.findViewById(R.id.poster_tab_layout) as PosterTabLayout).setViewPager(pager)
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_poster_home, container, false)
    }

    override fun createPresenter(): PosterPresenter {
        return PosterPresenter()
    }
}
