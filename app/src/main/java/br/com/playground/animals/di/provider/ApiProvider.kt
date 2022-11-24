package br.com.playground.animals.di.provider

import br.com.playground.animals.data.remote.api.AnimalsApi
import retrofit2.Retrofit

object ApiProvider {

    fun provideAnimalsApi(retrofit: Retrofit) = retrofit.create(AnimalsApi::class.java)
}
