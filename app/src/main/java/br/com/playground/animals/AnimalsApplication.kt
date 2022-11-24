package br.com.playground.animals

import android.app.Application
import br.com.playground.animals.di.modules.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AnimalsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AnimalsApplication)
            modules(AppModules().getModules())
        }
    }
}
