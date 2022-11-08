package sobaya.app.features.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import sobaya.app.features.randomDog.grid.RandomDogGridViewModel
import sobaya.app.features.searchCat.SearchCatViewModel
import sobaya.app.randomdog.detail.RandomDogDetailViewModel

actual fun platformModule(): Module = module {
    viewModel { RandomDogGridViewModel(get(), get()) }
    viewModel { RandomDogDetailViewModel(get()) }
    viewModel { SearchCatViewModel() }
}