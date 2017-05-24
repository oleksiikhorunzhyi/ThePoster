package khorunzhyicom.alex.theposter.service.mappers

import java.util.*

open class ListMapper<T, R>(val mapper: Mapper<T, R>) : Mapper<List<T>, List<R>> {

    override fun map(items: List<T>?): List<R> {
        if (items == null || items.isEmpty()) return emptyList()
        val mappableItems = items.mapTo(LinkedList<R>()) { mapper.map(it) }
        return mappableItems
    }
}
