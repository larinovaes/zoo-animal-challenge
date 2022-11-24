package br.com.playground.animals.data.remote.api

import br.com.playground.animals.data.remote.dto.AnimalDto
import retrofit2.Response
import retrofit2.http.GET

interface AnimalsApi {

    @GET("/animals/rand/10")
    suspend fun getAnimals(): Response<List<AnimalDto>>
}
