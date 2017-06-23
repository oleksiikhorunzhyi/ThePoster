package khorunzhyicom.alex.theposter.presentation.common.controller

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.github.nitrico.lastadapter.LastAdapter
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import findView
import khorunzhyicom.alex.theposter.BR
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.presentation.activity.PosterActivity
import khorunzhyicom.alex.theposter.presentation.common.controller.binder.ViewBinderController
import khorunzhyicom.alex.theposter.presentation.common.view.PosterTabView
import khorunzhyicom.alex.theposter.service.models.Movie

abstract class PosterTabController<V : PosterTabView, P : MvpPresenter<V>>(args: Bundle?) : ViewBinderController<V, P>(args), PosterTabView
{

    protected val movies: ObservableList<Movie> = ObservableArrayList<Movie>()
    protected val listView: RecyclerView by findView<RecyclerView>(getListLayoutId())

    override fun injector(): PresentationInjector = (activity as PosterActivity).injector()

    override fun showContent(content: List<Movie>) {
        this.movies.addAll(content)
    }

    protected fun getListLayoutId() = R.id.list_view

    override fun showError(error: String) {}

    override fun showProgress(progress: Int) {}

    override fun onAttach(view: View) {
        super.onAttach(view)
        listView.layoutManager = provideLayoutManager()

        LastAdapter(movies, BR.item)
                .map<Movie>(R.layout.item_view)
                .into(listView)
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        listView.adapter = null
    }

    protected fun provideLayoutManager(): RecyclerView.LayoutManager = LinearLayoutManager(view!!.context)
}