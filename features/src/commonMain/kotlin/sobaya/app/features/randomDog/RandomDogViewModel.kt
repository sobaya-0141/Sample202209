package sobaya.app.features.randomDog

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import sobaya.app.usecase.GetRandomDogUseCase
import sobaya.app.util.RetryTrigger
import sobaya.app.util.retryableFlow

class RandomDogViewModel(
    private val getRandomDogUseCase: GetRandomDogUseCase
) : ViewModel() {
    private val retryTrigger = RetryTrigger()
    val randomDog = retryableFlow(retryTrigger) {
        getRandomDogUseCase(1)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, sobaya.app.util.Result.Loading)

    fun fetchRandomDog() {
        retryTrigger.retry()
    }
}
