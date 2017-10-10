package khorunzhyicom.alex.theposter.service.providers

interface Provider<out T> {

    fun provide() : T
}