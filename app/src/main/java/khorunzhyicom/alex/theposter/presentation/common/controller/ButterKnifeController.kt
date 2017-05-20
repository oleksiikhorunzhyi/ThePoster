package khorunzhyicom.alex.theposter.presentation.common.controller


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

abstract class ButterKnifeController<V : MvpView, P : MvpPresenter<V>> : RxMvpController<V, P>() {

    override fun onCreateView(layoutInflater: LayoutInflater, viewGroup: ViewGroup): View {
        val view = inflateView(layoutInflater, viewGroup)
        ButterKnife.bind(this, view)
        onViewBound(view)
        return view
    }

    protected abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup): View

    protected open fun onViewBound(view: View) {}
}
