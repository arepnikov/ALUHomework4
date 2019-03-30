package pl.daftacademy.androidlevelup.entity

import pl.daftacademy.androidlevelup.database.Studio

interface Studios {

    fun get(): List<Studio>

}