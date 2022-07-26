package br.com.eduardovpessoa.di

import br.com.eduardovpessoa.data.remote.leadingdeathcauses.LeadingDeathCausesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { LeadingDeathCausesRepository(get()) }
}