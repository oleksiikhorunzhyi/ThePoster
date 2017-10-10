package khorunzhyicom.alex.theposter.service.providers

import rx.Observable

interface StreamProvider<T> : Provider<Observable<T>> {
}