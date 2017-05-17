package khorunzhyicom.alex.theposter.presentation.common.view;

import khorunzhyicom.alex.theposter.di.components.injector.Injector;

public interface DaggerView<I extends Injector> {

    I injector();

}
