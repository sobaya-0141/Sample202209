package sobaya.app.sample202209

import org.koin.core.context.startKoin
import sobaya.app.features.randomDog.grid.SwRandomDogGridState
import sobaya.app.sample202209.di.module

fun initKoin() {
    startKoin {
        modules(module)
    }
}

val randomDogGridState: SwRandomDogGridState = SwRandomDogGridState.initialState()