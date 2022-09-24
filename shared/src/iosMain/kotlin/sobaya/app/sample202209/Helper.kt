package sobaya.app.sample202209

import org.koin.core.context.startKoin
import sobaya.app.sample202209.di.module

fun initKoin() {
    startKoin {
        modules(module)
    }
}
