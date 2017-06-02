package khorunzhyicom.alex.theposter.service.mappers

import khorunzhyicom.alex.theposter.api.entities.ConfigurationEntity
import khorunzhyicom.alex.theposter.service.models.Configuration


class ConfigurationMapper : Mapper<ConfigurationEntity, Configuration> {

    override fun map(entity: ConfigurationEntity): Configuration {
        return Configuration(entity.baseUrl(),
                entity.secureUrl(),
                entity.backdropSizes(),
                entity.logoSizes(),
                entity.posterSizes(),
                entity.profileSizes(),
                entity.stillSizes())
    }
}