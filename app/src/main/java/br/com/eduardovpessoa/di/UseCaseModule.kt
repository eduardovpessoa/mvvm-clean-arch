package br.com.eduardovpessoa.di

import br.com.eduardovpessoa.domain.GetLeadingDeathCausesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetLeadingDeathCausesUseCase(get()) }
}