package br.com.playground.animals.domain

import br.com.playground.animals.data.remote.dto.AnimalDto
import br.com.playground.animals.data.repository.AnimalsRepository
import br.com.playground.animals.domain.usecases.AnimalsUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AnimalsUseCaseTest {

    private lateinit var animalsUseCase: AnimalsUseCase

    private val animalsRepository = mockk<AnimalsRepository>()

    @Before
    fun setup() {
        animalsUseCase = AnimalsUseCase(animalsRepository)
    }

    @Test
    fun `on fetchAnimals when request succeed then should return converted animals model`() {
        // arrange
        val animalsDtos = listOf(buildAnimalDto().copy(id = 1), buildAnimalDto().copy(id = 2))
        every { animalsRepository.getAnimals() } returns flowOf(animalsDtos)

        // act
        val result = runBlocking { animalsUseCase.fetchAnimals().first() }

        // assert
        assertEquals(animalsDtos[0].id.toString(), result[0].id)
        assertEquals(animalsDtos[1].id.toString(), result[1].id)
    }

    private fun buildAnimalDto() = AnimalDto(
        id = 1,
        name = "",
        latinName = "",
        animalType = "",
        activeTime = "",
        lengthMin = "",
        lengthMax = "",
        weightMin = "",
        weightMax = "",
        habitat = "",
        diet = "",
        lifespan = "",
        geoRange = "",
        imageLink = ""
    )
}
