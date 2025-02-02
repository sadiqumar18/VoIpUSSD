/*
 * Copyright (c) 2020. BoostTag E.I.R.L. Romell D.Z.
 * All rights reserved
 * porfile.romellfudi.com
 */

package com.romellfudi.ussd

import android.app.Application
import com.romellfudi.ussd.accessibility.di.accessibilityModule
import com.romellfudi.ussd.main.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * @autor Romell Domínguez
 * @date 2020-04-20
 * @version 1.0
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            printLogger()
            androidContext(this@App)
            modules(
                    appModule,
                    accessibilityModule
            )
        }
    }
}