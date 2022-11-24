package br.com.playground.animals.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.playground.animals.domain.model.AnimalModel
import br.com.playground.animals.domain.usecases.AnimalsUseCase
import br.com.playground.animals.presentation.list.AnimalsViewModel
import br.com.playground.animals.presentation.list.AnimalsViewModel.UIState
import br.com.playground.infrastructure.MainDispatcherRule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyOrder
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AnimalsViewModelTest {

    private lateinit var viewModel: AnimalsViewModel

    private val animalsUseCase = mockk<AnimalsUseCase>()

    private val uiStateObserverMock = mockk<Observer<UIState>>(relaxed = true)

    private val onRefreshObserverMock = mockk<Observer<Boolean>>(relaxed = true)

    @get:Rule
    val instantRuleExecutor = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setup() {
        viewModel = AnimalsViewModel(animalsUseCase)
        viewModel.uiState.observeForever(uiStateObserverMock)
        viewModel.onRefresh.observeForever(onRefreshObserverMock)
    }

    @After
    fun tearDown() {
        viewModel.uiState.removeObserver(uiStateObserverMock)
        viewModel.onRefresh.removeObserver(onRefreshObserverMock)
    }

    @Test
    fun `on fetchAnimals when request succeed then should emit success state`() {
        // arrange
        val animals = listOf(AnimalModel("1"), AnimalModel("2"))
        every { animalsUseCase.fetchAnimals() } returns flowOf(animals)

        // act
        viewModel.fetchAnimals()

        // result
        verifyOrder {
            uiStateObserverMock.onChanged(UIState.Loading)
            uiStateObserverMock.onChanged(UIState.Success(animals))
        }
    }

    @Test
    fun `on fetchAnimals when request occurs error then should emit error state`() {
        // arrange
        val errorFlow = flow<List<AnimalModel>> { throw IllegalArgumentException() }
        every { animalsUseCase.fetchAnimals() } returns errorFlow

        // act
        viewModel.fetchAnimals()

        // result
        verifyOrder {
            uiStateObserverMock.onChanged(UIState.Loading)
            uiStateObserverMock.onChanged(UIState.Error)
        }
    }

    @Test
    fun `on onRefreshAnimals then should fetch animals`() {
        // arrange
        val animals = listOf(AnimalModel("1"), AnimalModel("2"))
        every { animalsUseCase.fetchAnimals() } returns flowOf(animals)

        // act
        viewModel.onRefreshAnimals()

        // result
        verifyOrder {
            onRefreshObserverMock.onChanged(true)
            animalsUseCase.fetchAnimals()
            onRefreshObserverMock.onChanged(false)
        }
    }
}
