package khorunzhyicom.alex.theposter.api.actions.common;

import khorunzhyicom.alex.theposter.api.auth.AuthData;

public interface AuthorizableAction {
    void authorize(AuthData authData);
}
