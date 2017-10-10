package khorunzhyicom.alex.theposter.presentation.popular

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import khorunzhyicom.alex.theposter.service.commands.ext.lifecycleStateComposer
import khorunzhyicom.alex.theposter.service.interactors.PopularMoviesInteractor
import javax.inject.Inject

class PopularMoviesPresenter : MvpBasePresenter<PopularMoviesView>() {

    @Inject lateinit var popularMoviesInteractor: PopularMoviesInteractor

    override fun attachView(view: PopularMoviesView) {
        super.attachView(view)
        view.injector().inject(this)
        subscribeToMoviesUpdates()

        popularMoviesInteractor.requestMovies()
    }

    private fun subscribeToMoviesUpdates() {
        popularMoviesInteractor.pipe()
                .observe()
                .lifecycleStateComposer(view)
                .subscribe({ view.showContent(it) }, { view.showError(it.localizedMessage) })
    }
}
