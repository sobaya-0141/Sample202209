package sobaya.app.sample202209.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import sobaya.app.randomdog.detail.RandomDogDetailViewModel
import sobaya.app.sample202209.features.randomDog.grid.RandomDogGridViewModel

actual fun platformModule(): Module = module {
    viewModel { RandomDogGridViewModel(get(), get()) }
    viewModel { RandomDogDetailViewModel(get()) }
}
