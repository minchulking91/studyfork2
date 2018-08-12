package kr.co.sleeptime.koinprac

import android.app.Application
import kr.co.sleeptime.koinprac.di.MyModule
import org.koin.android.ext.android.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, MyModule.getModules())
    }
}

