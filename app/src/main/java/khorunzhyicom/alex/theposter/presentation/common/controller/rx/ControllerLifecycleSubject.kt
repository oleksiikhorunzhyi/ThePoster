package khorunzhyicom.alex.theposter.presentation.common.controller.rx

import android.view.View

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Controller.LifecycleListener

import rx.subjects.BehaviorSubject
import rx.subjects.PublishSubject

/**
 * A simple utility class that will create a [BehaviorSubject] that calls onNext when events
 * occur in your [Controller]
 */
object ControllerLifecycleSubject {

    fun wrap(controller: Controller): PublishSubject<ControllerEvent> {
        val subject = PublishSubject.create<ControllerEvent>()

        controller.addLifecycleListener(object : LifecycleListener() {
            override fun preCreateView(controller: Controller) {
                subject.onNext(ControllerEvent.CREATE_VIEW)
            }

            override fun preAttach(controller: Controller, view: View) {
                subject.onNext(ControllerEvent.ATTACH)
            }

            override fun preDetach(controller: Controller, view: View) {
                subject.onNext(ControllerEvent.DETACH)
            }

            override fun preDestroyView(controller: Controller, view: View) {
                subject.onNext(ControllerEvent.DESTROY_VIEW)
            }

            override fun preDestroy(controller: Controller) {
                subject.onNext(ControllerEvent.DESTROY)
            }
        })

        return subject
    }

}
