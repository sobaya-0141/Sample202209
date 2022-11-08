package sobaya.app.features.di

import org.koin.dsl.module
import sobaya.app.features.randomDog.grid.RandomDogGridViewModel
import sobaya.app.randomdog.detail.RandomDogDetailViewModel

actual fun platformModule() = module {
    single { RandomDogGridViewModel(get(), get()) }
    single { RandomDogDetailViewModel(get()) }
}
