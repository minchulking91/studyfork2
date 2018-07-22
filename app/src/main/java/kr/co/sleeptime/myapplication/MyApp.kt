package kr.co.sleeptime.myapplication

import android.app.Application

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        appProvider = AppProvider(this)
    }

    lateinit var appProvider: AppProvider
}