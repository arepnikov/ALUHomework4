package pl.daftacademy.androidlevelup.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudioDao {

    @Insert
    fun add(studios: Collection<Studio>)

    @Query("SELECT * FROM studio")
    fun get(): List<Studio>

    @Query("SELECT * FROM studio WHERE studio.name in (:names) LIMIT :limit")
    fun findByName(names: Array<String>, limit: Int): List<Studio>

    @Query("SELECT * FROM studio WHERE studio.id = :studioId LIMIT 1")
    fun findById(studioId: Int): Studio
}