package khorunzhyicom.alex.theposter.service.composers;

import io.techery.janet.Command;
import rx.Observable;

public final class CommandResultComposer<T> implements Observable.Transformer<Command<T>, T> {

    @Override
    public Observable<T> call(Observable<Command<T>> commandObservable) {
        return commandObservable.map(Command::getResult);
    }
}