package sobaya.app.sample202209.di

import org.koin.dsl.module
import sobaya.app.randomdog.detail.RandomDogDetailViewModel
import sobaya.app.sample202209.features.randomDog.grid.RandomDogGridViewModel

actual fun platformModule() = module {
    single { RandomDogGridViewModel(get(), get()) }
    single { RandomDogDetailViewModel(get()) }
}
