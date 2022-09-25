package sobaya.lib.randomdog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        getRandomDogUseCase()
    }.stateIn(viewModelScope, SharingStarted.Eagerly, sobaya.app.util.Result.Loading)

    fun fetchRandomDog() {
        retryTrigger.retry()
    }
}
