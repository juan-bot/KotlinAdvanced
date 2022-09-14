package com.example.profile.di.modules

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class appKoin : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@appKoin)
            modules(listOf(appModule, appModuleDashboard))
        }
    }
}
