package sobaya.app.sample202209.repository.di

import org.koin.dsl.module
import sobaya.app.sample202209.repository.DogRepository

val repositoryModule = module {
    single { DogRepository(get(), get()) }
}
