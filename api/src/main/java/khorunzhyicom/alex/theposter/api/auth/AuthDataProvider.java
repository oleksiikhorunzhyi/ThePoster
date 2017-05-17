package khorunzhyicom.alex.theposter.api.auth;

import org.immutables.value.Value;

@Value.Immutable
public interface AuthDataProvider<T extends AuthData> {

    T provide();
}
