package com.example.laboratorio05.repositories

import com.example.laboratorio05.data.dao.ActorDao
import com.example.laboratorio05.data.model.ActorModel

class ActorRepository(private val actorDao: ActorDao) {

    // get all actors
    suspend fun getActors() = actorDao.getAllActors()

    // insert actor
    suspend fun insertActor(actor:ActorModel) = actorDao.insertActor(actor)
}