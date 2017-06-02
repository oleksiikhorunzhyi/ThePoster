package khorunzhyicom.alex.theposter.api.actions.configuration;


import io.techery.janet.http.annotations.HttpAction;
import io.techery.janet.http.annotations.Response;
import khorunzhyicom.alex.theposter.api.actions.common.PosterHttpAction;
import khorunzhyicom.alex.theposter.api.actions.common.Responsible;
import khorunzhyicom.alex.theposter.api.entities.ConfigurationEntity;
import khorunzhyicom.alex.theposter.api.entities.ConfigurationHolder;

@HttpAction("/3/configuration")
public class ConfigurationHttpAction extends PosterHttpAction implements Responsible<ConfigurationEntity> {

    @Response ConfigurationHolder holder;

    @Override public ConfigurationEntity response() {
        return holder.get();
    }
}
