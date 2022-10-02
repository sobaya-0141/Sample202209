package sobaya.app.sample202209.android

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import sobaya.app.sample202209.di.module
import sobaya.lib.local.di.databaseModule

class SampleApplication : Application(), ImageLoaderFactory {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SampleApplication)
            androidLogger()
            modules(module + databaseModule)
        }
    }

    override fun newImageLoader(): ImageLoader {
        val builder = ImageLoader.Builder(this)
        builder.interceptorDispatcher(Dispatchers.Main)

        return builder.build()
    }
}
