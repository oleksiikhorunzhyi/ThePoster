package khorunzhyicom.alex.theposter.presentation.common.controller.rx

import android.os.Bundle

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import com.trello.rxlifecycle.LifecycleTransformer
import com.trello.rxlifecycle.RxLifecycle

import khorunzhyicom.alex.theposter.presentation.common.view.RxView
import khorunzhyicom.alex.theposter.service.composers.IoToMainComposer
import rx.Observable
import rx.subjects.PublishSubject


abstract class RxMvpController<V : MvpView, P : MvpPresenter<V>> (args: Bundle?) : MvpController<V, P>(args), RxView {

    internal var lifecycleSubject: PublishSubject<ControllerEvent> = ControllerLifecycleSubject.wrap(this)

    override fun <T> bind(observable: Observable<T>): Observable<T> {
        return observable.compose(bindUntilDetachView<T>())
    }

    override fun <T> bindToMainComposer(observable: Observable<T>): Observable<T> {
        return bind(observable).compose(IoToMainComposer<T>())
    }

    protected fun <T> bindUntilDetachView(): LifecycleTransformer<T> {
        return bindUntilEvent(ControllerEvent.DETACH)
    }

    protected fun <T> bindUntilEvent(event: ControllerEvent): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent<T, ControllerEvent>(lifecycleSubject, event)
    }
}
