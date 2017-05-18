package khorunzhyicom.alex.theposter.api.converter;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

import java.util.ServiceLoader;

import io.techery.janet.gson.GsonConverter;

public final class PosterGsonConverter {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public GsonConverter provide() {
        GsonBuilder builder = new GsonBuilder()
                .serializeNulls()
                .setDateFormat(DATE_FORMAT)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        //
        for (TypeAdapterFactory factory : ServiceLoader.load(TypeAdapterFactory.class)) {
            builder.registerTypeAdapterFactory(factory);
        }
        return new GsonConverter(builder.create());
    }
}
