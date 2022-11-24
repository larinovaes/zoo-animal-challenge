package br.com.playground.animals.data.repository

import br.com.playground.animals.data.local.dao.AnimalDao
import br.com.playground.animals.data.local.entity.AnimalEntity
import br.com.playground.animals.data.remote.api.AnimalsApi
import br.com.playground.animals.data.remote.dto.AnimalDto
import kotlinx.coroutines.flow.flow

class AnimalsRepository(
    private val animalsApi: AnimalsApi,
    private val animalDao: AnimalDao
) {

    fun getAnimals() = flow {
        val animalsCached = animalDao.getAllAnimals().map { AnimalDto(it) }
        emit(animalsCached)
        val result = animalsApi.getAnimals().body().orEmpty()
        if (result.isEmpty()) {
            error("Could not retrieve animals from api")
        }
        result
            .map { AnimalEntity(it) }
            .also { animalDao.update(it) }
        emit(result)
    }
}
