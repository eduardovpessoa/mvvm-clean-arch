package br.com.eduardovpessoa.di

import br.com.eduardovpessoa.data.remote.LeadingDeathCausesApi
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(15L, TimeUnit.SECONDS)
            .readTimeout(15L, TimeUnit.SECONDS)
            .writeTimeout(15L, TimeUnit.SECONDS)
            .build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/resource")
            .client(okHttpClient)
            .build()
    }

    single { provideHttpClient() }
    single { provideRetrofit(okHttpClient = get()) }
    single { get<Retrofit>().create(LeadingDeathCausesApi::class.java) }
}