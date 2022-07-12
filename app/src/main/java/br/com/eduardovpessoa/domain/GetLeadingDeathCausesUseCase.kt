package br.com.eduardovpessoa.domain

import br.com.eduardovpessoa.data.remote.LeadingDeathCausesRepository

class GetLeadingDeathCausesUseCase(
    private val repository: LeadingDeathCausesRepository
) {
    suspend operator fun invoke() =
        try {
            repository.fetchLeadingDeathCauses()
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
}