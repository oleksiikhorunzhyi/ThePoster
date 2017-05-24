package khorunzhyicom.alex.theposter.service.common


import io.techery.janet.ActionHolder
import io.techery.janet.ActionService
import io.techery.janet.ActionServiceWrapper
import io.techery.janet.JanetException
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.di.components.ApiComponent
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.service.commands.base.InjectableCommand

class InjectableCommandActionService(service: ActionService, app: App) : ActionServiceWrapper(service) {

    private val injector: Injector

    init {
        this.injector = Injector.create(app.apiComponent())
    }

    override fun <A> onInterceptSend(holder: ActionHolder<A>): Boolean {
        val action = holder.action() as? InjectableCommand ?: return false
        injector.inject(action)
        return false
    }

    override fun <A> onInterceptCancel(holder: ActionHolder<A>) {}

    override fun <A> onInterceptStart(holder: ActionHolder<A>) {}

    override fun <A> onInterceptProgress(holder: ActionHolder<A>, progress: Int) {}

    override fun <A> onInterceptSuccess(holder: ActionHolder<A>) {}

    override fun <A> onInterceptFail(holder: ActionHolder<A>, e: JanetException): Boolean {
        return false
    }

    private class Injector private constructor(private val injector: CommandInjector) {

        fun inject(command: InjectableCommand) = command.injectTo(injector)

        companion object {

            fun create(apiComponent: ApiComponent): Injector = Injector(apiComponent)

        }
    }
}
