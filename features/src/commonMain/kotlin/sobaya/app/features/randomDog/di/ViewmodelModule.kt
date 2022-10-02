package sobaya.app.features.randomDog.di

import org.koin.dsl.module
import sobaya.app.features.randomDog.RandomDogViewModel
import sobaya.app.features.randomDog.grid.RandomDogGridViewModel
import sobaya.app.randomdog.detail.RandomDogDetailViewModel

val viewModelModule = module {
    single { RandomDogViewModel(get()) }
    single { RandomDogGridViewModel(get(), get()) }
    single { RandomDogDetailViewModel(get()) }
}