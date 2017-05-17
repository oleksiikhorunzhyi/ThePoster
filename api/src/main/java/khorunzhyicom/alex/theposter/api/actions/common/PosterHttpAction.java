package khorunzhyicom.alex.theposter.api.actions.common;

import io.techery.janet.http.annotations.Query;
import io.techery.janet.http.annotations.RequestHeader;
import io.techery.janet.http.annotations.Status;
import khorunzhyicom.alex.theposter.api.auth.AuthData;

public abstract class PosterHttpAction implements AuthorizableAction {

    @Query("api_key") String token;
    @Status int statusCode;

    @Override
    public void authorize(AuthData authData) {
        this.token = authData.token();
    }

    public int statusCode() {
        return statusCode;
    }
}
