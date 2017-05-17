package khorunzhyicom.alex.theposter.presentation.common.controller;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class ButterKnifeController<V extends MvpView, P extends MvpPresenter<V>> extends RxMvpController<V, P> {

    private Unbinder unbinder;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View view = inflateView(layoutInflater, viewGroup);
        unbinder = ButterKnife.bind(this, view);
        onViewBound(view);
        return view;
    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        super.onDestroyView(view);
        unbinder.unbind();
        unbinder = null;
    }

    protected abstract View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container);

    protected void onViewBound(View view){}
}
