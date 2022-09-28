package sobaya.app.sample202209.android.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sobaya.lib.randomdog.RandomDogViewModel
import sobaya.lib.randomdog.detail.RandomDogDetailViewModel
import sobaya.lib.randomdog.grid.RandomDogGridViewModel

val viewModelModule = module {
    viewModel { RandomDogViewModel(get()) }
    viewModel { RandomDogGridViewModel(get(), get()) }
    viewModel { RandomDogDetailViewModel(get()) }
}
