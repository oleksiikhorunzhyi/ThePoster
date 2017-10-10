package khorunzhyicom.alex.theposter.presentation.upcoming

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import khorunzhyicom.alex.theposter.service.commands.ext.lifecycleStateComposer
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
                .lifecycleStateComposer(view)
                .subscribe({ view.showContent(it) }, { view.showError(it.localizedMessage) })
    }
}
