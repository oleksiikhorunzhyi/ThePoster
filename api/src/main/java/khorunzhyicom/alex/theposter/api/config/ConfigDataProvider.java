package khorunzhyicom.alex.theposter.api.config;

import org.immutables.value.Value;

@Value.Immutable
public interface ConfigDataProvider<T extends ConfigData> {

    T provide();
}
