package sobaya.app.sample202209.usecase.di

import org.koin.dsl.module
import sobaya.app.sample202209.usecase.DeleteInsertDogUseCase
import sobaya.app.sample202209.usecase.GetRandomDogUseCase
import sobaya.app.sample202209.usecase.SelectDogUseCase

val useCaseModule = module {
    single { GetRandomDogUseCase(get()) }
    single { SelectDogUseCase(get()) }
    single { DeleteInsertDogUseCase(get()) }
}
