package pl.daftacademy.androidlevelup.database

import androidx.room.*
import pl.daftacademy.androidlevelup.entity.Movie

@Entity(
    indices = [Index("studioId")],
    foreignKeys = [
        ForeignKey(entity = Studio::class, parentColumns = ["id"], childColumns = ["studioId"])
    ]
)
class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val year: Int,
    val genres: String,
    val studioId: Int) {

    companion object {
        fun fromEntity(movieWithStudio: Pair<Movie, Studio>): pl.daftacademy.androidlevelup.database.Movie {
            val (movie, studio) = movieWithStudio
            return Movie(0, movie.title, movie.year, movie.genres.joinToString(","), studio.id)
        }
    }
}

