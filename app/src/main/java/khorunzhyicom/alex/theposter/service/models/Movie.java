package khorunzhyicom.alex.theposter.service.models;


import android.support.annotation.Nullable;

import org.immutables.value.Value;

import java.util.Date;

@Value.Immutable
public interface Movie {

    String title();
    String originalTitle();
    @Nullable Date releaseDate();
    @Nullable Integer budget();
    @Nullable Integer voteCount();
    @Nullable Double voteAverage();
    @Nullable Double popularity();
    @Nullable String backdropPath();
    @Nullable String overview();
    @Nullable String posterPath();
}
