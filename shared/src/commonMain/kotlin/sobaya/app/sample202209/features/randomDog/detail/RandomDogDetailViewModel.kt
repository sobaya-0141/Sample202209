package sobaya.app.randomdog.detail

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import sobaya.app.sample202209.usecase.SelectDogUseCase

class RandomDogDetailViewModel(
    private val selectDogUseCase: SelectDogUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(RandomDogDetailUiState.initialState())
    val uiState: StateFlow<RandomDogDetailUiState> = _uiState

    init {
        selectDogUseCase().onEach { dogs ->
            _uiState.value = uiState.value.copy(message = dogs.getOrNull(0)?.message)
        }.launchIn(viewModelScope)
    }
}

data class RandomDogDetailUiState(
    val message: String?
) {
    companion object {
        fun initialState() = RandomDogDetailUiState(null)
    }
}
