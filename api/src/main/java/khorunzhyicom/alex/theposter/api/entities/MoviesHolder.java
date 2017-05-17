package khorunzhyicom.alex.theposter.api.entities;

import com.google.gson.annotations.SerializedName;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.List;

import khorunzhyicom.alex.theposter.api.entities.MovieEntity;
import khorunzhyicom.alex.theposter.api.entities.common.EntityHolder;

/**
 * Author: Alexei Khorunzhyi
 * Date: 20.10.15.
 * Date: 12:52.
 */
@Gson.TypeAdapters
@Value.Immutable
public interface MoviesHolder extends EntityHolder<List<MovieEntity>> {

    @Override @SerializedName("results") List<MovieEntity> get();
}
