package khorunzhyicom.alex.theposter.service.models


data class Configuration(val baseUrl: String,
                         val secureUrl: String,
                         val backdropSizes: List<String>?,
                         val logoSizes: List<String>?,
                         val posterSizes: List<String>?,
                         val profileSizes: List<String>?,
                         val stillSizes: List<String>?)