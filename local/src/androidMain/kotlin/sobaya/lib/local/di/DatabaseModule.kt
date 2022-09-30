package sobaya.lib.local.di

import com.squareup.sqldelight.android.AndroidSqliteDriver
import org.koin.dsl.module
import sobaya.lib.local.AppDatabase

val databaseModule = module {
    single {
        val driver = AndroidSqliteDriver(AppDatabase.Schema, get(), "sample.db")
        AppDatabase(driver)
    }
}
