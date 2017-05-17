package khorunzhyicom.alex.theposter.api.converter;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import io.techery.janet.gson.GsonConverter;
import khorunzhyicom.alex.theposter.api.entities.GsonAdaptersMovieEntity;
import khorunzhyicom.alex.theposter.api.entities.GsonAdaptersMoviesHolder;

public final class PosterGsonConverter {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public GsonConverter provide() {
        GsonBuilder builder = new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        builder.registerTypeAdapterFactory(new GsonAdaptersMovieEntity());
        builder.registerTypeAdapterFactory(new GsonAdaptersMoviesHolder());
        return new GsonConverter(builder.create());
    }
}
