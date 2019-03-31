package pl.daftacademy.androidlevelup.database

import androidx.room.Embedded
import androidx.room.Relation

class MovieStudio(
    @Embedded
    var movie: Movie = Movie(-1, "", -1, "", -1),
    @Relation(parentColumn = "studioId", entityColumn = "id", entity = Studio::class)
    var studios: List<Studio> = listOf()
)