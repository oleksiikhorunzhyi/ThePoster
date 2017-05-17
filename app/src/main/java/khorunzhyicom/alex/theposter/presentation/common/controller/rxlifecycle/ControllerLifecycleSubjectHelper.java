package khorunzhyicom.alex.theposter.presentation.common.controller.rxlifecycle;

import android.support.annotation.NonNull;
import android.view.View;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Controller.LifecycleListener;

import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/**
 * A simple utility class that will create a {@link BehaviorSubject} that calls onNext when events
 * occur in your {@link Controller}
 */
public class ControllerLifecycleSubjectHelper {

    private ControllerLifecycleSubjectHelper() { }

    public static PublishSubject<ControllerEvent> create(Controller controller) {
        final PublishSubject<ControllerEvent> subject = PublishSubject.create();

        controller.addLifecycleListener(new LifecycleListener() {
            @Override
            public void preCreateView(@NonNull Controller controller) {
                subject.onNext(ControllerEvent.CREATE_VIEW);
            }

            @Override
            public void preAttach(@NonNull Controller controller, @NonNull View view) {
                subject.onNext(ControllerEvent.ATTACH);
            }

            @Override
            public void preDetach(@NonNull Controller controller, @NonNull View view) {
                subject.onNext(ControllerEvent.DETACH);
            }

            @Override
            public void preDestroyView(@NonNull Controller controller, @NonNull View view) {
                subject.onNext(ControllerEvent.DESTROY_VIEW);
            }

            @Override
            public void preDestroy(@NonNull Controller controller) {
                subject.onNext(ControllerEvent.DESTROY);
            }
        });

        return subject;
    }

}
