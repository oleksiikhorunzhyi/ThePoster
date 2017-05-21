package khorunzhyicom.alex.theposter.presentation.common.controller.binder


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import khorunzhyicom.alex.theposter.presentation.common.controller.rx.RxMvpController

abstract class ViewBinderController<V : MvpView, P : MvpPresenter<V>> : RxMvpController<V, P> {

    constructor() : super(null)
    constructor(args: Bundle?) : super(args)

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflateView(inflater, container)
        ViewFinder.setup(this, view)
        onViewBound(view)
        return view
    }

    final override fun onDestroyView(view: View) {
        ViewFinder.tearDown(this)
    }

    open fun onViewBound(view: View) { }

    abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup): View
}
