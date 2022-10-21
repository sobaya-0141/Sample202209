package sobaya.lib.local.di

import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import org.koin.dsl.module
import sobaya.lib.local.AppDatabase

val databaseModule = module {
    single {
        val driver = NativeSqliteDriver(AppDatabase.Schema, "sample.db")
        AppDatabase(driver)
    }
}
