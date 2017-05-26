package khorunzhyicom.alex.theposter.presentation.upcoming

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
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
import khorunzhyicom.alex.theposter.presentation.activity.adapter.TabView
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController
import khorunzhyicom.alex.theposter.presentation.now.UpcomingMoviesPresenter
import khorunzhyicom.alex.theposter.presentation.now.UpcomingMoviesView
import khorunzhyicom.alex.theposter.presentation.top.TopMoviesController
import khorunzhyicom.alex.theposter.service.models.Movie

class UpcomingMoviesController : ViewBinderController<UpcomingMoviesView, UpcomingMoviesPresenter>(), UpcomingMoviesView, TabView {

    val movies: ObservableList<Movie> = ObservableArrayList<Movie>()

    val listView: RecyclerView by findView<RecyclerView>(R.id.list_view)

    override fun createPresenter(): UpcomingMoviesPresenter = UpcomingMoviesPresenter()

    override fun injector(): PresentationInjector = (applicationContext as App).uiInjector()

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View = inflater.inflate(R.layout.controller_upcoming_movies, container, false)

    override fun updateMovies(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
    }

    override fun showError(error: String) {}

    override fun title(): Int = R.string.tab_upcoming

    override fun controller(): UpcomingMoviesController = this

    override fun onAttach(view: View) {
        super.onAttach(view)
        listView.layoutManager = LinearLayoutManager(view.context)
        LastAdapter(movies, BR.item)
                .map<Movie>(R.layout.item_view)
                .into(listView)
    }
}
