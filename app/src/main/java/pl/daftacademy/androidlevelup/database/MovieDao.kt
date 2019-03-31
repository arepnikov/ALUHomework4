package pl.daftacademy.androidlevelup.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert
    fun add(movies: Collection<Movie>)

    @Query("SELECT * FROM movie")
    fun get(): List<Movie>

//    @Query(
//        "SELECT movie.*, studio.name AS studioName FROM movie" +
//        "INNER JOIN studio ON studio.id = movie.studioId"
//    )
//    fun getMoviesWithStudioName(): List<MovieStudio>
}
