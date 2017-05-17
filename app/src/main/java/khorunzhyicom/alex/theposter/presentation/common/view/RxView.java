package khorunzhyicom.alex.theposter.presentation.common.view;

import rx.Observable;

public interface RxView {

    <T> Observable<T> bindView(Observable<T> observable);

    <T> Observable<T> bindViewToMainComposer(Observable<T> observable);
}
