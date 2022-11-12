package sobaya.app.sample202209.di

import org.koin.dsl.module
import sobaya.app.features.di.platformModule
import sobaya.app.network.di.catApi
import sobaya.app.network.di.dogApi
import sobaya.app.repository.di.repositoryModule
import sobaya.app.usecase.di.useCaseModule

val module = module {
    single { dogApi }
    single { catApi }
} + useCaseModule + repositoryModule + platformModule()
