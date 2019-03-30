package pl.daftacademy.androidlevelup.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import pl.daftacademy.androidlevelup.entity.Movie

@Entity(
    foreignKeys = [
        ForeignKey(entity = Studio::class, parentColumns = ["id"], childColumns = ["studioId"])
    ]
)
class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val year: Int,
    val genres: String,
    val studioId: Int?) {

    fun toEntity() = Movie(title, year, genres.split(','), null)

    companion object {
        fun fromEntity(movie: Movie): pl.daftacademy.androidlevelup.database.Movie {
            return Movie(0, movie.title, movie.year, movie.genres.joinToString(","), null)
        }
    }
}