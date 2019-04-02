package pl.daftacademy.androidlevelup.database

import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies
import pl.daftacademy.androidlevelup.database.Movie as DbMovie

class RoomMovies(private val studioDao: StudioDao, private val movieDao: MovieDao) : Movies {

    override fun add(moviesWithStudiosPairs: Collection<Pair<Movie, Studio>>) {
        movieDao.add(moviesWithStudiosPairs.map(DbMovie.Companion::fromEntity))
    }

    override fun get(): List<Movie> = studioDao.get().flatMap { studioMovies ->
        studioMovies.movies.map {
            Movie(it.title, it.year, it.genres.split(","), studioMovies.studio.name)
        }
    }
}
