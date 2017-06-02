package khorunzhyicom.alex.theposter.api.entities;

import com.google.gson.annotations.SerializedName;

import org.immutables.gson.Gson;
import org.immutables.value.Value;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Author: Alexei Khorunzhyi
 * Date: 18.04.17.
 * Date: 20:06.
 */
@Gson.TypeAdapters
@Value.Immutable
public interface ConfigurationEntity {

    @SerializedName("base_url") String baseUrl();
    @SerializedName("secure_base_url") String secureUrl();
    @Nullable @SerializedName("backdrop_sizes") List<String> backdropSizes();
    @Nullable @SerializedName("logo_sizes") List<String> logoSizes();
    @Nullable @SerializedName("poster_sizes") List<String> posterSizes();
    @Nullable @SerializedName("profile_sizes") List<String> profileSizes();
    @Nullable @SerializedName("still_sizes") List<String> stillSizes();
}