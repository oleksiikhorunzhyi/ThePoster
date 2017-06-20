package khorunzhyicom.alex.theposter.presentation.now

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.nitrico.lastadapter.LastAdapter
import findView
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.BR
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.activity.PosterActivity
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController
import khorunzhyicom.alex.theposter.service.models.Movie

class NowPlayingMoviesController (args: Bundle? = null) : ViewBinderController<NowPlayingMoviesView, NowPlayingMoviesPresenter>(args), NowPlayingMoviesView {

    val movies: ObservableList<Movie> = ObservableArrayList<Movie>()

    val listView: RecyclerView by findView<RecyclerView>(R.id.list_view)

    override fun createPresenter(): NowPlayingMoviesPresenter = NowPlayingMoviesPresenter()

    override fun injector(): PresentationInjector = (activity as PosterActivity).injector()

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View = inflater.inflate(R.layout.controller_now_movies, container, false)

    override fun tabTitle(): Int = R.string.tab_now

    override fun tabController(): NowPlayingMoviesController = this

    override fun showContent(content: List<Movie>) {
        this.movies.addAll(content)
    }

    override fun showError(error: String) {}

    override fun showProgress(progress: Int) {}

    override fun onAttach(view: View) {
        super.onAttach(view)
        listView.layoutManager = LinearLayoutManager(view.context)
        LastAdapter(movies, BR.item)
                .map<Movie>(R.layout.item_view)
                .into(listView)
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        listView.adapter = null
    }
}
