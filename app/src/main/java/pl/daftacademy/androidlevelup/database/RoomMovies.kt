package pl.daftacademy.androidlevelup.database

import androidx.lifecycle.LiveData
import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies
import pl.daftacademy.androidlevelup.database.Movie as DbMovie

class RoomMovies(private val studioDao: StudioDao, private val movieDao: MovieDao) : Movies {

    override fun add(moviesWithStudios: Collection<Pair<Movie, Studio>>) {
        movieDao.add(moviesWithStudios.map(DbMovie.Companion::fromEntity))
    }

    override fun get(): List<Movie> = movieDao.get().map {
        Movie(it.movie.title, it.movie.year, it.movie.genres.split(","), it.studios.first().name)
    }
}
