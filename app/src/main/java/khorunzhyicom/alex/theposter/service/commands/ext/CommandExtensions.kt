package khorunzhyicom.alex.theposter.service.commands.ext

import io.techery.janet.ActionPipe
import io.techery.janet.ActionState
import io.techery.janet.Command
import io.techery.janet.Janet
import io.techery.janet.helper.ActionStateToActionTransformer
import khorunzhyicom.alex.theposter.api.actions.common.Responsible
import khorunzhyicom.alex.theposter.presentation.common.view.RxView
import khorunzhyicom.alex.theposter.service.composers.IoToMainComposer
import rx.Observable
import rx.Scheduler
import rx.schedulers.Schedulers
import kotlin.reflect.KClass


/**
 * Inline janet extensions
 */

inline fun <reified A : Any> Janet.createPipe(clazz: KClass<A>): ActionPipe<A> {
    return createPipe(clazz.java, Schedulers.io())
}

inline fun <reified A : Any> Janet.createPipe(clazz: KClass<A>, scheduler: Scheduler): ActionPipe<A> {
    return createPipe(clazz.java, scheduler)
}

/**
 * Inline transformers for http actions
 */

inline fun <reified A : Any, reified R: Responsible<A>> Observable<R>.transform(): Observable<A> {
    return map { it.response() }
}

inline fun <reified A : Any, reified E : Any, reified R: Responsible<A>> Observable<R>.transformWith(crossinline transformer:(A) -> E): Observable<E> {
    return transform().map { transformer.invoke(it) }
}

inline fun <reified A : Any, reified R: Responsible<A>> Observable<ActionState<R>>.transformFromState(): Observable<A> {
    return compose (ActionStateToActionTransformer<R>()).transform()
}

inline fun <reified A : Any, reified E : Any, reified R: Responsible<A>> Observable<ActionState<R>>.transformFromStateWith(crossinline transformer:(A) -> E): Observable<E> {
    return transformFromState().map { transformer.invoke(it) }
}


/**
 * Inline transformers for commands
 */
inline fun <reified A : Any, reified R: Command<A>> Observable<R>.commandResultComposer(): Observable<A> {
    return map { it.result }
}

inline fun <reified A : Any, reified R: Command<A>> Observable<R>.commandIoComposer(): Observable<A> {
    return compose(IoToMainComposer<R>()).commandResultComposer()
}

inline fun <reified A : Any, reified R: Command<A>> Observable<R>.defaultComposer(lifecycle: RxView): Observable<A> {
    return compose { lifecycle.bindToLifecycle(it) }.commandIoComposer()
}

inline fun <reified A : Any, reified R: Command<A>> Observable<ActionState<R>>.defaultStateComposer(lifecycle: RxView): Observable<A> {
    return compose(ActionStateToActionTransformer<R>()).defaultComposer(lifecycle)
}

