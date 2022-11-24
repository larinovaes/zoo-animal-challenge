package br.com.playground.animals.di.provider

import br.com.playground.animals.data.local.AppDatabase

object DaoProvider {

    fun provideAnimalDao(appDatabase: AppDatabase) = appDatabase.getAnimalDao()
}
