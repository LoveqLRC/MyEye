package com.example.liaoruochen.myeye

import android.app.Application
import timber.log.Timber

class App :Application() {


    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        Timber.d("test app ------------------")
    }
}