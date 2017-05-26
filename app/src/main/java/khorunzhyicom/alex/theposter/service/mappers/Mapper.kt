package khorunzhyicom.alex.theposter.service.mappers

interface Mapper<T, R> {

    fun map(entity: T): R
}
