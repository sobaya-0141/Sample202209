package sobaya.app.sample202209.android.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sobaya.app.sample202209.android.MainActivityViewModel
import sobaya.lib.randomdog.RandomDogViewModel

val viewModelModule = module {
    viewModel {
        MainActivityViewModel(get())
        RandomDogViewModel(get())
    }
}
