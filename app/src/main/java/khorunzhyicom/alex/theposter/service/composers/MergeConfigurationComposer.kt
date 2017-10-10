package khorunzhyicom.alex.theposter.service.composers

import khorunzhyicom.alex.theposter.service.models.Configuration
import khorunzhyicom.alex.theposter.service.models.Movie
import rx.Observable
import rx.functions.Func2


class MergeConfigurationComposer(val configObservable: Observable<Configuration>) : Observable.Transformer<List<Movie>, List<Movie>> {

    override fun call(observable: Observable<List<Movie>>): Observable<List<Movie>> {
        return observable.flatMap { Observable.from(it)
                .withLatestFrom(configObservable,
                        Func2 { movie: Movie, config: Configuration -> return@Func2 concat(movie, config) }) }
                .toList()
    }

    // TODO :: manage image sizes
    fun concat(movie: Movie, configuration: Configuration): Movie {
        return movie.copy(posterPath = "${configuration.baseUrl}${configuration.posterSizes?.get(2)}${movie.posterPath}")
    }
}