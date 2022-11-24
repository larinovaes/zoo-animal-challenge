package br.com.playground.animals.data

import br.com.playground.animals.data.local.dao.AnimalDao
import br.com.playground.animals.data.local.entity.AnimalEntity
import br.com.playground.animals.data.remote.api.AnimalsApi
import br.com.playground.animals.data.remote.dto.AnimalDto
import br.com.playground.animals.data.repository.AnimalsRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class AnimalsRepositoryTest {

    private lateinit var animalsRepository: AnimalsRepository

    private var animalDao = mockk<AnimalDao>()

    private var animalsApi = mockk<AnimalsApi>()

    @Before
    fun setup() {
        animalsRepository = AnimalsRepository(animalsApi, animalDao)
    }

    @Test
    fun `on getAnimals then should certify that cache logic is working as expected`() =
        runBlocking {
            // arrange
            val animalsEntities = listOf(buildAnimalEntity().copy(id = 1))
            val animalsDtos = listOf(buildAnimalDto().copy(id = 2))
            coEvery { animalDao.getAllAnimals() } returns animalsEntities
            coEvery { animalsApi.getAnimals() } returns Response.success(animalsDtos)
            coEvery { animalDao.update(any()) } returns Unit

            // act
            val result = animalsRepository.getAnimals()

            // assert
            val fromCache = result.first()
            val fromApi = result.last()
            assertEquals(1, fromCache.first().id)
            assertEquals(2, fromApi.first().id)
        }

    @Test(expected = Throwable::class)
    fun `on getAnimals when api occurs error then should throw an error`() {
        // arrange
        val animalsEntities = listOf(buildAnimalEntity().copy(id = 1))
        coEvery { animalDao.getAllAnimals() } returns animalsEntities
        coEvery { animalsApi.getAnimals() } returns Response.error(400, "".toResponseBody())
        coEvery { animalDao.update(any()) } returns Unit

        // act
        runBlocking { animalsRepository.getAnimals().collect() }
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

    private fun buildAnimalEntity() = AnimalEntity(
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
