package br.com.playground.animals.domain.usecases

import br.com.playground.animals.data.repository.AnimalsRepository
import br.com.playground.animals.domain.model.AnimalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AnimalsUseCase(private val animalsRepository: AnimalsRepository) {

    fun fetchAnimals(): Flow<List<AnimalModel>> {
        return animalsRepository.getAnimals().map { animalsDto ->
            animalsDto.map { AnimalModel(it) }
        }
    }
}
