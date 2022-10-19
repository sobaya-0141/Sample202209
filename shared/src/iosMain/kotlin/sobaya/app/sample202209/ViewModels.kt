package sobaya.app.sample202209

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import sobaya.app.randomdog.detail.RandomDogDetailViewModel
import sobaya.app.sample202209.features.randomDog.grid.RandomDogGridViewModel

class ViewModels : KoinComponent {
    fun getRandomDogGridViewModel() = get<RandomDogGridViewModel>()
    fun getRandomDogDetailViewModel() = get<RandomDogDetailViewModel>()
}
