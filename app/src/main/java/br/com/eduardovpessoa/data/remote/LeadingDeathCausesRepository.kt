package br.com.eduardovpessoa.data.remote

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class LeadingDeathCausesRepository(
    private val api: LeadingDeathCausesApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun fetchLeadingDeathCauses(): String? {
        return withContext(dispatcher) {
            async { api.fetchLeadingDeathCauses().await() } //TODO BODY
        }.await()
    }
}