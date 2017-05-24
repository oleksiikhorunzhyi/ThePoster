package khorunzhyicom.alex.theposter.service.composers

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class IoToMainComposer<T> : Observable.Transformer<T, T> {

    override fun call(observable: Observable<T>): Observable<T> {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}
