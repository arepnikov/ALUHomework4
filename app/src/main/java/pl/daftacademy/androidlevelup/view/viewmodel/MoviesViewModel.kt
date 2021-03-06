package pl.daftacademy.androidlevelup.view.viewmodel

import androidx.lifecycle.ViewModel
import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies
import pl.daftacademy.androidlevelup.entity.Studios

class MoviesViewModel(val studios: Studios, private vararg val movies: Movies) : ViewModel() {

    fun getMovies(genre: String?): List<Movie> = if (genre != null) {
        movies.flatMap(Movies::get).filter { genre in it.genres }
    } else {
        movies.flatMap(Movies::get)
    }
}
