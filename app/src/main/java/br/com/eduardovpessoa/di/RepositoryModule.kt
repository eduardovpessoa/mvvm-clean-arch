package br.com.eduardovpessoa.di

import br.com.eduardovpessoa.data.remote.LeadingDeathCausesRepository
import org.koin.dsl.module

val repositoryModule = module{
    single { LeadingDeathCausesRepository(get()) }
}