package sobaya.app.features.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.dsl.module
import sobaya.app.features.randomDog.grid.RandomDogGridViewModel
import sobaya.app.randomdog.detail.RandomDogDetailViewModel

actual fun platformModule() = module {
    single { RandomDogGridViewModel(get(), get()) }
    single { RandomDogDetailViewModel(get()) }
}

object ViewModels : KoinComponent {
    fun getRandomDogGridViewModel() = get<RandomDogGridViewModel>()
    fun getRandomDogDetailViewModel() = get<RandomDogDetailViewModel>()
}