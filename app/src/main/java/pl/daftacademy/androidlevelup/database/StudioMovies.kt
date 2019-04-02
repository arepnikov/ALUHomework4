package pl.daftacademy.androidlevelup.database

import androidx.room.Embedded
import androidx.room.Relation

class StudioMovies(
    @Embedded
    var studio: Studio = Studio(-1, ""),
    @Relation(parentColumn = "id", entityColumn = "studioId", entity = Movie::class)
    var movies: List<Movie> = listOf()
)