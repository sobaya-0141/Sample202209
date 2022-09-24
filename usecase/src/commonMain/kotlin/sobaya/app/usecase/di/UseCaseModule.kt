package sobaya.app.usecase.di

import org.koin.dsl.module
import sobaya.app.usecase.GetRandomDogUseCase

val useCaseModule = module {
    single {
        GetRandomDogUseCase(get())
    }
}
