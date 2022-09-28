package sobaya.lib.randomdog.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import sobaya.app.usecase.SelectDogUseCase

class RandomDogDetailViewModel(
    private val selectDogUseCase: SelectDogUseCase
) : ViewModel() {
    var uiState by mutableStateOf(RandomDogDetailUiState.initialState())
        private set

    init {
        selectDogUseCase().onEach { dogs ->
            uiState = uiState.copy(message = dogs.getOrNull(0)?.message)
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