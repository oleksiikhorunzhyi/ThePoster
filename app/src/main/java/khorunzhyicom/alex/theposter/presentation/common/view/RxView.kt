package khorunzhyicom.alex.theposter.presentation.common.view

import rx.Observable

interface RxView {

    fun <T> bind(observable: Observable<T>): Observable<T>

    fun <T> bindToMainComposer(observable: Observable<T>): Observable<T>
}
