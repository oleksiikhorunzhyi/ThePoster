package khorunzhyicom.alex.theposter.presentation.activity;


import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import butterknife.BindView;
import khorunzhyicom.alex.theposter.R;
import khorunzhyicom.alex.theposter.presentation.activity.adapter.PosterTabLayout;
import khorunzhyicom.alex.theposter.presentation.activity.adapter.PosterTabsAdapter;
import khorunzhyicom.alex.theposter.presentation.common.controller.ButterKnifeController;
import khorunzhyicom.alex.theposter.presentation.popular.PopularMoviesController;
import khorunzhyicom.alex.theposter.presentation.top.TopMoviesController;

public class PosterController extends ButterKnifeController<PosterView, PosterPresenter> implements PosterView {

    @BindView(R.id.poster_view_pager) ViewPager viewPager;

    @Override
    protected void onViewBound(View view) {
        super.onViewBound(view);
        viewPager.setAdapter(new PosterTabsAdapter(this, Arrays.asList(new TopMoviesController(), new PopularMoviesController())));
        ((PosterTabLayout)getActivity().findViewById(R.id.poster_tab_layout)).setViewPager(viewPager);
    }

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.controller_poster_home, container, false);
    }

    @NonNull
    @Override
    public PosterPresenter createPresenter() {
        return new PosterPresenter();
    }
}
