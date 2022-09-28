package sobaya.app.sample202209.android

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import sobaya.app.sample202209.android.di.viewModelModule
import sobaya.app.sample202209.di.module
import sobaya.lib.local.di.databaseModule

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SampleApplication)
            androidLogger()
            modules(module + viewModelModule + databaseModule)
        }
    }
}
