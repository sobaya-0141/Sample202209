package sobaya.app.features.randomDog.grid

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
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

    private val _isDataCreated = MutableStateFlow<String?>(null)
    val isDataCreated: StateFlow<String?> = _isDataCreated

    fun onClickDog(message: String) {
        deleteInsertDogUseCase(message, "success")
        _isDataCreated.value = message
    }

    fun setIsDataCreated(message: String?) {
        _isDataCreated.value = message
    }

    fun fetchRandomDog() {
        retryTrigger.retry()
    }

    companion object {
        const val LIMIT_DOG_COUNT = 50
    }
}
