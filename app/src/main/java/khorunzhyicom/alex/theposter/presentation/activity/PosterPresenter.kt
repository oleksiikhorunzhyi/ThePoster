package khorunzhyicom.alex.theposter.presentation.activity


import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import khorunzhyicom.alex.theposter.core.PosterAppInitializer
import javax.inject.Inject

class PosterPresenter : MvpBasePresenter<PosterView>() {

    @Inject lateinit var posterAppInitializer: PosterAppInitializer

    override fun attachView(view: PosterView) {
        super.attachView(view)
        view.injector().inject(this)
        posterAppInitializer.initialize()
    }
}
