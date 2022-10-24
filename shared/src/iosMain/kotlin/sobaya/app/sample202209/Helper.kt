package sobaya.app.sample202209

import org.koin.core.context.startKoin
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.sample202209.di.module
import sobaya.lib.local.di.databaseModule
import sobaya.app.util.Result

fun initKoin() {
    startKoin {
        modules(module + databaseModule)
    }
}


val randomDogResponse = RandomDogResponse(listOf(), "")
val result = Result.Success(randomDogResponse)
val error = Result.Error(Exception())
val loading = Result.Loading
