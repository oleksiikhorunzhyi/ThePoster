package khorunzhyicom.alex.theposter.service.mappers

import java.util.*

open class ListMapper<in T, out R>(val mapper: Mapper<T, R>) : Mapper<List<T>, List<R>> {

    override fun map(entity: List<T>): List<R> = entity.mapTo(LinkedList<R>()) { mapper.map(it) }
}
