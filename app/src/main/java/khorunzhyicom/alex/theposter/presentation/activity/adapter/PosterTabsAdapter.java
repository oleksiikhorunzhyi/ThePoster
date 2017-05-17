package khorunzhyicom.alex.theposter.presentation.activity.adapter;


import android.support.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.support.RouterPagerAdapter;

import java.util.List;

public class PosterTabsAdapter extends RouterPagerAdapter {

    private final List<Controller> tabs;

    public PosterTabsAdapter(@NonNull Controller host, List<Controller> tabs) {
        super(host);
        this.tabs = tabs;
    }

    @Override
    public void configureRouter(@NonNull Router router, int position) {
        if (!router.hasRootController()) {
            Controller controller = tabs.get(position);
            router.pushController(RouterTransaction.with(controller));
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "movies";
    }

}

