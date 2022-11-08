package sobaya.app.usecase.di

import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module
import sobaya.app.usecase.DeleteInsertDogUseCase
import sobaya.app.usecase.GetRandomDogUseCase
import sobaya.app.usecase.SearchCatUseCase
import sobaya.app.usecase.SelectDogUseCase

val useCaseModule = module {
    single { GetRandomDogUseCase(get()) }
    single { SelectDogUseCase(get()) }
    single { DeleteInsertDogUseCase(get()) }
    single { (coroutineScope: CoroutineScope) -> SearchCatUseCase(get(), coroutineScope) }
}
