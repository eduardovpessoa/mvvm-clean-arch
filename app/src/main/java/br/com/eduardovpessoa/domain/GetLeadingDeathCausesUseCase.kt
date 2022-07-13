package br.com.eduardovpessoa.domain

import br.com.eduardovpessoa.data.remote.leadingdeathcauses.LeadingDeathCausesRepository

class GetLeadingDeathCausesUseCase(private val repository: LeadingDeathCausesRepository) {
    suspend operator fun invoke() {
        repository.fetchLeadingDeathCausesAsync().let {
            if(it.isSuccessful){
                it.body()
            }
        }
    }
}