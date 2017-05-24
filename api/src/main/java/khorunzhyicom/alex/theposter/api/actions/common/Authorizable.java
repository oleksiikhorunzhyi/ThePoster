package khorunzhyicom.alex.theposter.api.actions.common;

import khorunzhyicom.alex.theposter.api.auth.AuthData;

public interface Authorizable {
    void authorize(AuthData authData);
}
