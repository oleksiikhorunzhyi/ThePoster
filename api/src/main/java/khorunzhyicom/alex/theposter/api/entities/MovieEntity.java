package khorunzhyicom.alex.theposter.api.entities;

import com.google.gson.annotations.SerializedName;

import org.immutables.gson.Gson;
import org.immutables.value.Value;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

import khorunzhyicom.alex.theposter.api.entities.common.Identifiable;

/**
 * Author: Alexei Khorunzhyi
 * Date: 18.04.17.
 * Date: 20:06.
 */
@Gson.TypeAdapters
@Value.Immutable
public interface MovieEntity extends Identifiable<Integer> {

    @SerializedName("title") String title();
    @SerializedName("original_title") String originalTitle();
    @Nullable @SerializedName("vote_count") Integer voteCount();
    @Nullable @SerializedName("vote_average") Double voteAverage();
    @Nullable @SerializedName("popularity") Double popularity();
    @Nullable @SerializedName("budget") Integer budget();
    @Nullable @SerializedName("backdrop_path") String backdropPath();
    @Nullable @SerializedName("overview") String overview();
    @Nullable @SerializedName("poster_path") String posterPath();
    @Nullable @SerializedName("release_date") Date releaseDate();
}
