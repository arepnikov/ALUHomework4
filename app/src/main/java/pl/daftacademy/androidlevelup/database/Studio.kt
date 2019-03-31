package pl.daftacademy.androidlevelup.database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index("name")])
data class Studio(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)
