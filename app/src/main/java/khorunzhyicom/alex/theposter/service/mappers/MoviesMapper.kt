package khorunzhyicom.alex.theposter.service.mappers

import khorunzhyicom.alex.theposter.api.entities.MovieEntity
import khorunzhyicom.alex.theposter.service.models.Movie

/**
 * Author: Alexei Khorunzhyi
 * Date: 10.05.17.
 * Date: 20:06.
 */
class MoviesMapper(mapper: Mapper<MovieEntity, Movie>) : ListMapper<MovieEntity, Movie>(mapper)
