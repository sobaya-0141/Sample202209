package sobaya.app.repository.di

import org.koin.dsl.module
import sobaya.app.repository.DogRepository

val repositoryModule = module {
    single { DogRepository(get(), get()) }
}
