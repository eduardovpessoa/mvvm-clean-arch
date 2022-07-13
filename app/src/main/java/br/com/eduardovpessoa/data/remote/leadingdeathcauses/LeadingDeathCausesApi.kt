package br.com.eduardovpessoa.data.remote.leadingdeathcauses

import br.com.eduardovpessoa.data.remote.dto.LeadingDeathCauseItem
import br.com.eduardovpessoa.util.AppConsts.Companion.ENDPOINT_LEADING_DEATH_CAUSES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface LeadingDeathCausesApi {
    @GET(ENDPOINT_LEADING_DEATH_CAUSES)
    suspend fun fetchLeadingDeathCausesAsync(@Header("X-App-Token") token: String): Response<List<LeadingDeathCauseItem>>
}