package pl.daftacademy.androidlevelup.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import pl.daftacademy.androidlevelup.R
import java.util.concurrent.Executors

@Database(entities = [Movie::class, Studio::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movies(): MovieDao
    abstract fun studios(): StudioDao

    companion object {
        lateinit var INSTANCE: MovieDatabase

        fun initIfNeeded(context: Context) {
            if (MovieDatabase.Companion::INSTANCE.isInitialized.not()) {
                INSTANCE = Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
                    .allowMainThreadQueries()
                    .addCallback(seedDatabaseCallback(context))
                    .build()
            }
        }

        private fun seedDatabaseCallback(context: Context): Callback {
            return object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val initStudios = context.resources.getStringArray(R.array.studios).map { Studio(0, it) }
                    Executors.newSingleThreadExecutor().execute { INSTANCE.studios().add(initStudios) }
                }
            }
        }
    }
}
