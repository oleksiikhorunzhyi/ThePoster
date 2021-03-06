package khorunzhyicom.alex.theposter.presentation.top

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import khorunzhyicom.alex.theposter.service.commands.ext.lifecycleStateComposer

import khorunzhyicom.alex.theposter.service.interactors.TopMoviesInteractor
import javax.inject.Inject

class TopMoviesPresenter : MvpBasePresenter<TopMoviesView>() {

    @Inject lateinit var interactor: TopMoviesInteractor

    override fun attachView(view: TopMoviesView) {
        super.attachView(view)
        view.injector().inject(this)
        subscribeToMoviesUpdates()

        interactor.requestMovies()
    }

    private fun subscribeToMoviesUpdates() {
        interactor.pipe()
                .observe()
                .lifecycleStateComposer(view)
                .subscribe({ view.showContent(it) }, { view.showError(it.localizedMessage) })
    }
}
