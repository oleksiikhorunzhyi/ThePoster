package khorunzhyicom.alex.theposter.service.mappers

interface Mapper<in T, out R> {

    fun map(entity: T): R
}
