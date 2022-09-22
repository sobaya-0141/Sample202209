package sobaya.app.sample202209.android

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.usecase.GetRandomDogUseCase
import sobaya.app.util.Result
import sobaya.app.util.RetryTrigger
import sobaya.app.util.retryableFlow

class MainActivityViewModel(private val getRandomDogUseCase: GetRandomDogUseCase) : ViewModel() {
    private val randomDogRetryTrigger = RetryTrigger()
    private val randomDog: StateFlow<sobaya.app.util.Result<RandomDogResponse>?> =
        retryableFlow(randomDogRetryTrigger) {
        getRandomDogUseCase()
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        null
    )
    var state by mutableStateOf("")
        private set

    init {
        ovserveDogApi()
    }

    private fun ovserveDogApi() {
        randomDog.onEach { result ->
            state = when (result) {
                is Result.Success -> {
                    result.data.status
                }
                is Result.Error -> {
                    result.exception?.message ?: ""
                }
                Result.Loading -> {
                    "LOADING"
                }
                else -> {
                    throw IllegalStateException()
                }
            }
        }.launchIn(viewModelScope)
    }
}

val viewModelModule = module {
    viewModel {
        MainActivityViewModel(get())
    }
}