package khorunzhyicom.alex.theposter.presentation.common.view

import rx.Observable

interface RxView {

    fun <T> bindToLifecycle(observable: Observable<T>): Observable<T>
}
