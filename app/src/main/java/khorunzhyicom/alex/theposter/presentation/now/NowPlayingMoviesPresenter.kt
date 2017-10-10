package khorunzhyicom.alex.theposter.presentation.now

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import khorunzhyicom.alex.theposter.service.commands.ext.lifecycleStateComposer
import khorunzhyicom.alex.theposter.service.interactors.ConfigurationInteractor
import khorunzhyicom.alex.theposter.service.interactors.NowPlayingMoviesInteractor
import javax.inject.Inject

class NowPlayingMoviesPresenter : MvpBasePresenter<NowPlayingMoviesView>()  {

    @Inject lateinit var interactor: NowPlayingMoviesInteractor
    @Inject lateinit var configInteractor: ConfigurationInteractor

    override fun attachView(view: NowPlayingMoviesView) {
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
