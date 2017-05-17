package khorunzhyicom.alex.theposter.presentation.common.controller;

import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;

import khorunzhyicom.alex.theposter.presentation.common.controller.rxlifecycle.ControllerEvent;
import khorunzhyicom.alex.theposter.presentation.common.controller.rxlifecycle.ControllerLifecycleSubjectHelper;
import khorunzhyicom.alex.theposter.presentation.common.view.RxView;
import khorunzhyicom.alex.theposter.service.composers.IoToMainComposer;
import rx.Observable;
import rx.subjects.PublishSubject;


public abstract class RxMvpController<V extends MvpView, P extends MvpPresenter<V>> extends MvpController<V, P> implements RxView {

    private final PublishSubject<ControllerEvent> lifecycleSubject;

    public RxMvpController() {
        this(null);
    }

    public RxMvpController(Bundle args) {
        super(args);
        lifecycleSubject = ControllerLifecycleSubjectHelper.create(this);
    }

    @Override
    public <T> Observable<T> bindView(Observable<T> observable) {
        return observable.compose(bindUntilDetachView());
    }

    @Override
    public <T> Observable<T> bindViewToMainComposer(Observable<T> observable) {
        return bindView(observable).compose(new IoToMainComposer<>());
    }

    protected final <T> LifecycleTransformer<T> bindUntilDetachView() {
        return bindUntilEvent(ControllerEvent.DETACH);
    }

    protected final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ControllerEvent event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }
}
