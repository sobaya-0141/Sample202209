package sobaya.app.sample202209

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import sobaya.app.features.randomDog.grid.RandomDogGridViewModel
import sobaya.app.randomdog.detail.RandomDogDetailViewModel

class ViewModels : KoinComponent {
    fun getRandomDogGridViewModel() = get<RandomDogGridViewModel>()
    fun getRandomDogDetailViewModel() = get<RandomDogDetailViewModel>()
}