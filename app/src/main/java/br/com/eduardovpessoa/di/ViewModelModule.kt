package br.com.eduardovpessoa.di

import br.com.eduardovpessoa.ui.leadingdeathcauses.LeadingDeathCausesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LeadingDeathCausesViewModel(get()) }
}