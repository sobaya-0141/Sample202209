package sobaya.lib.randomdog.grid

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.usecase.DeleteInsertDogUseCase
import sobaya.app.usecase.GetRandomDogUseCase
import sobaya.app.util.Result
import sobaya.app.util.RetryTrigger
import sobaya.app.util.retryableFlow

class RandomDogGridViewModel(
    private val getRandomDogUseCase: GetRandomDogUseCase,
    private val deleteInsertDogUseCase: DeleteInsertDogUseCase
) : ViewModel() {
    private val retryTrigger = RetryTrigger()
    val randomDog: StateFlow<Result<RandomDogResponse>> = retryableFlow(retryTrigger) {
        getRandomDogUseCase(LIMIT_DOG_COUNT)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, Result.Loading)

    var isDataCreated by mutableStateOf<String?>(null)
        private set

    fun onClickDog(message: String) {
        deleteInsertDogUseCase(message, "success")
        isDataCreated = message
    }

    fun setIsDataCreated(message: String?) {
        isDataCreated = message
    }

    fun fetchRandomDog() {
        retryTrigger.retry()
    }

    companion object {
        const val LIMIT_DOG_COUNT = 50
    }
}
