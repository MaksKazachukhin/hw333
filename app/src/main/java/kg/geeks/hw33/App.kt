package kg.geeks.hw33

import android.app.Application
import kg.geeks.hw33.data.module.networkModule
import kg.geeks.hw33.data.module.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(networkModule, uiModule)
        }
    }
}