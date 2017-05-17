package khorunzhyicom.alex.theposter.service.common;


import io.techery.janet.ActionHolder;
import io.techery.janet.ActionService;
import io.techery.janet.ActionServiceWrapper;
import io.techery.janet.JanetException;
import khorunzhyicom.alex.theposter.application.App;
import khorunzhyicom.alex.theposter.di.components.ApiComponent;
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector;
import khorunzhyicom.alex.theposter.service.commands.InjectableCommand;

public class InjectableCommandActionService extends ActionServiceWrapper {

    private final Injector injector;

    public InjectableCommandActionService(ActionService service, App app) {
        super(service);
        this.injector = Injector.create((app.apiComponent()));
    }

    @Override
    protected <A> boolean onInterceptSend(ActionHolder<A> holder) {
        A action = holder.action();
        if (!(action instanceof InjectableCommand)) return false;
        injector.inject((InjectableCommand) action);
        return false;
    }

    @Override
    protected <A> void onInterceptCancel(ActionHolder<A> holder) {}

    @Override
    protected <A> void onInterceptStart(ActionHolder<A> holder) {}

    @Override
    protected <A> void onInterceptProgress(ActionHolder<A> holder, int progress) {}

    @Override
    protected <A> void onInterceptSuccess(ActionHolder<A> holder) {}

    @Override
    protected <A> boolean onInterceptFail(ActionHolder<A> holder, JanetException e) {
        return false;
    }

    private static class Injector {

        private final CommandInjector injector;

        private Injector(CommandInjector injector) {
            this.injector = injector;
        }

        public static Injector create(ApiComponent apiComponent) {
            return new Injector(apiComponent);
        }

        public void inject(InjectableCommand command) {
            command.injectTo(injector);
        }
    }
}
