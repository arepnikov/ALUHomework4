package pl.daftacademy.androidlevelup.entity

import pl.daftacademy.androidlevelup.database.Studio

interface Movies {

    fun add(movies: Collection<Pair<Movie, Studio>>)

    fun get(): List<Movie>
}
