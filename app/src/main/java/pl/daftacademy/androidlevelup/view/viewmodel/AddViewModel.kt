package pl.daftacademy.androidlevelup.view.viewmodel

import androidx.lifecycle.ViewModel
import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies
import pl.daftacademy.androidlevelup.entity.Studios

class AddViewModel(private val movies: Movies, private val studios: Studios) : ViewModel() {

    fun addMovie(title: String, year: String, genres: List<String>, studio: String) {
        val newMovie = Movie(title, year.toInt(), genres, studio)
        val studio = studios.findByName(arrayOf(studio)).first()
        movies.add(listOf(Pair(newMovie, studio)))
    }
}
