package pl.daftacademy.androidlevelup.view.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pl.daftacademy.androidlevelup.database.MovieDatabase
import pl.daftacademy.androidlevelup.database.RoomMovies
import pl.daftacademy.androidlevelup.database.RoomStudios
import pl.daftacademy.androidlevelup.entity.Movies
import pl.daftacademy.androidlevelup.entity.Studios
import pl.daftacademy.androidlevelup.files.AssetsMovies

class ViewModelFactory(application: Application) : ViewModelProvider.Factory {

    private val dbMovies: Movies
    private val assetMovies: Movies
    private val dbStudios: Studios

    init {
        MovieDatabase.initIfNeeded(application)
        assetMovies = AssetsMovies(application)
        dbMovies    = RoomMovies(MovieDatabase.INSTANCE.studios(), MovieDatabase.INSTANCE.movies())
        dbStudios   = RoomStudios(MovieDatabase.INSTANCE.studios())
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(dbStudios, dbMovies, assetMovies) as T
            }
            modelClass.isAssignableFrom(AddViewModel::class.java) -> {
                AddViewModel(dbMovies, dbStudios) as T
            }
            else -> throw IllegalArgumentException("Unknown view model ${modelClass.simpleName}")
        }
    }
}
