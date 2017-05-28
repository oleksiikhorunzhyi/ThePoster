package khorunzhyicom.alex.theposter.presentation.now

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import khorunzhyicom.alex.theposter.service.commands.ext.defaultStateComposer
import khorunzhyicom.alex.theposter.service.interactors.NowPlayingMoviesInteractor
import javax.inject.Inject

class NowPlayingMoviesPresenter : MvpBasePresenter<NowPlayingMoviesView>()  {

    @Inject lateinit var interactor: NowPlayingMoviesInteractor

    override fun attachView(view: NowPlayingMoviesView) {
        super.attachView(view)
        view.injector().inject(this)
        subscribeToMoviesUpdates()

        interactor.requestMovies()
    }

    private fun subscribeToMoviesUpdates() {
        interactor.pipe()
                .observe()
                .defaultStateComposer(view)
                .subscribe({ view.showContent(it) }, { view.showError(it.localizedMessage) })
    }
}
