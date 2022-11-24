package br.com.playground.animals.di.modules

import br.com.playground.animals.data.local.AppDatabase
import br.com.playground.animals.data.repository.AnimalsRepository
import br.com.playground.animals.di.provider.ApiProvider
import br.com.playground.animals.di.provider.DaoProvider
import br.com.playground.animals.di.provider.NetworkProvider
import br.com.playground.animals.domain.usecases.AnimalsUseCase
import br.com.playground.animals.presentation.list.AnimalsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class AppModules {

    fun getModules() = listOf(
        provideViewModelModule(),
        provideDomainModule(),
        provideDataSourceModule()
    )

    private fun provideViewModelModule() = module {
        viewModel { AnimalsViewModel(get()) }
    }

    private fun provideDomainModule() = module {
        factory { AnimalsUseCase(get()) }
    }

    private fun provideDataSourceModule() = module {
        factory { AnimalsRepository(get(), get()) }
        single { NetworkProvider.provideRetrofit() }
        single { ApiProvider.provideAnimalsApi(get()) }
        single { AppDatabase.getDataBase(androidApplication()) }
        single { DaoProvider.provideAnimalDao(get()) }
    }
}
