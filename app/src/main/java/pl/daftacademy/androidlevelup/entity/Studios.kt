package pl.daftacademy.androidlevelup.entity

import pl.daftacademy.androidlevelup.database.Studio

interface Studios {

    fun add(studios: Collection<Studio>)

    fun get(): List<Studio>

    fun findByName(names: Array<String>): List<Studio>

}