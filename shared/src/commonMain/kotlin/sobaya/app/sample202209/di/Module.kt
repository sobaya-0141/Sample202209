package sobaya.app.sample202209.di

import org.koin.dsl.module
import sobaya.app.sample202209.network.di.dogApi
import sobaya.app.sample202209.repository.di.repositoryModule
import sobaya.app.sample202209.usecase.di.useCaseModule

val module = module {
    single {
        dogApi
    }
} + useCaseModule + repositoryModule + platformModule()
