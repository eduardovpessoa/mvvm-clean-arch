package br.com.eduardovpessoa

import android.app.Application
import br.com.eduardovpessoa.di.apiModule
import br.com.eduardovpessoa.di.repositoryModule
import br.com.eduardovpessoa.di.useCaseModule
import br.com.eduardovpessoa.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationConfig : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@ApplicationConfig)
            modules(
                apiModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}