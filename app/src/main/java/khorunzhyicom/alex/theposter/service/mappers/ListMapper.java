package khorunzhyicom.alex.theposter.service.mappers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import rx.functions.Func1;

public class ListMapper<T, R> implements Func1<List<T>, List<R>> {

    public final Mapper<T, R> mapper;

    public ListMapper(Mapper<T, R> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<R> call(List<T> items) {
        if (items == null || items.isEmpty()) return Collections.emptyList();

        List<R> mappableItems = new LinkedList<>();
        for (T item : items) {
            mappableItems.add(mapper.map(item));
        }
        return mappableItems;
    }
}
