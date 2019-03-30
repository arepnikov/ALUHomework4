package pl.daftacademy.androidlevelup.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface StudioDao {

    @Query("SELECT * FROM studio")
    fun get(): List<Studio>

}