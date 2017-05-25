package khorunzhyicom.alex.theposter.presentation.now

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import khorunzhyicom.alex.theposter.service.commands.ext.defaultStateComposer
import khorunzhyicom.alex.theposter.service.interactors.NowPlayingMoviesInteractor
import khorunzhyicom.alex.theposter.service.interactors.UpcomingMoviesInteractor
import javax.inject.Inject

class UpcomingMoviesPresenter : MvpBasePresenter<UpcomingMoviesView>()  {

    @Inject lateinit var interactor: UpcomingMoviesInteractor

    override fun attachView(view: UpcomingMoviesView) {
        super.attachView(view)
        view.injector().inject(this)
        subscribeToMoviesUpdates()

        interactor.requestMovies()
    }

    private fun subscribeToMoviesUpdates() {
        interactor.pipe()
                .observe()
                .defaultStateComposer(view)
                .subscribe({ view.updateMovies(it) }, { view.showError(it.localizedMessage) })
    }
}
