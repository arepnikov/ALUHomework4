package pl.daftacademy.androidlevelup.database

import pl.daftacademy.androidlevelup.entity.Studios

class RoomStudios(private val studioDao: StudioDao): Studios {
    override fun get(): List<Studio> = studioDao.get()
}