package pl.daftacademy.androidlevelup.database

import pl.daftacademy.androidlevelup.entity.Studios

class RoomStudios(private val studioDao: StudioDao): Studios {

    override fun add(studios: Collection<Studio>) = studioDao.add(studios)

    override fun get(): List<Studio> = studioDao.get()

    override fun findByName(names: Array<String>) = studioDao.findByName(names, names.size)

}