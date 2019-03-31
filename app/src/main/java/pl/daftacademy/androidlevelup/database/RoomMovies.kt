package pl.daftacademy.androidlevelup.database

import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies
import pl.daftacademy.androidlevelup.database.Movie as DbMovie

class RoomMovies(private val movieDao: MovieDao) : Movies {

    override fun add(moviesWithStudios: Collection<Pair<Movie, Studio>>) =
        movieDao.add(moviesWithStudios.map(DbMovie.Companion::fromEntity))

//    override fun get(): List<Movie> = movieDao.getMoviesWithStudioName().map(MovieStudio::toEntity)

    override fun get(): List<Movie> = movieDao.get().map(DbMovie::toEntity)


}
