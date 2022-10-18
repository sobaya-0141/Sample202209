package sobaya.app.sample202209.features.randomDog

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import sobaya.app.sample202209.usecase.GetRandomDogUseCase
import sobaya.app.sample202209.util.Result
import sobaya.app.sample202209.util.RetryTrigger
import sobaya.app.sample202209.util.retryableFlow

class RandomDogViewModel(
    private val getRandomDogUseCase: GetRandomDogUseCase
) : ViewModel() {
    private val retryTrigger = RetryTrigger()
    val randomDog = retryableFlow(retryTrigger) {
        getRandomDogUseCase(1)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, Result.Loading)

    fun fetchRandomDog() {
        retryTrigger.retry()
    }
}
