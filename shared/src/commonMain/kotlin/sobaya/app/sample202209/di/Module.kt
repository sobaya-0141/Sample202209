package sobaya.app.sample202209.di

import org.koin.dsl.module
import sobaya.app.network.di.dogApi
import sobaya.app.repository.di.repositoryModule
import sobaya.app.usecase.di.useCaseModule

val module = module {
    single {
        dogApi
    }
} + useCaseModule + repositoryModule
