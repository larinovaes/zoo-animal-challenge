package br.com.playground.animals.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.playground.animals.domain.model.AnimalModel
import br.com.playground.animals.domain.usecases.AnimalsUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class AnimalsViewModel(
    private var animalsUseCase: AnimalsUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UIState>()
    val uiState: LiveData<UIState> = _uiState

    private val _onRefresh = MutableLiveData<Boolean>()
    val onRefresh: LiveData<Boolean> = _onRefresh

    fun onRefreshAnimals() {
        _onRefresh.value = true
        fetchAnimals()
    }

    fun fetchAnimals() = viewModelScope.launch {
        _uiState.value = UIState.Loading
        animalsUseCase.fetchAnimals()
            .catch { _uiState.value = UIState.Error }
            .collect { _uiState.value = UIState.Success(it) }
            .also { _onRefresh.value = false }
    }

    sealed class UIState {
        object Error : UIState()
        object Loading : UIState()
        data class Success(val animals: List<AnimalModel>) : UIState()
    }
}
