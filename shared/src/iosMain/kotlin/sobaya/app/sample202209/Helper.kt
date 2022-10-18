package sobaya.app.sample202209

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import sobaya.app.randomdog.detail.RandomDogDetailViewModel
import sobaya.app.sample202209.di.module
import sobaya.app.sample202209.features.randomDog.grid.RandomDogGridViewModel

fun initKoin() {
    startKoin {
        modules(module)
    }
}

object ViewModels : KoinComponent {
    fun getRandomDogGridViewModel() = get<RandomDogGridViewModel>()
    fun getRandomDogDetailViewModel() = get<RandomDogDetailViewModel>()
}
