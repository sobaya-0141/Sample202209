package sobaya.app.sample202209

import org.koin.core.context.startKoin
import sobaya.app.sample202209.di.module
import sobaya.lib.local.di.databaseModule

fun initKoin() {
    startKoin {
        modules(module + databaseModule)
    }
}
