package khorunzhyicom.alex.theposter.di.components;


import android.content.Context;
import android.content.res.Resources;

import khorunzhyicom.alex.theposter.App;

public interface ContextProvider {

    App application();
    Context context();
    Resources resources();
}
