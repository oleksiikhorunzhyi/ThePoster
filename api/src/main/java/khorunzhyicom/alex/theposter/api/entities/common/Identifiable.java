package khorunzhyicom.alex.theposter.api.entities.common;

import com.google.gson.annotations.SerializedName;

/**
 * Author: Alexei Khorunzhyi
 * Date: 22.04.17.
 * Date: 20:06.
 */
public interface Identifiable<T> {
    @SerializedName("id") T id();
}
