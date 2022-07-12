package br.com.eduardovpessoa.data.remote

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface LeadingDeathCausesApi {
    @GET("/jb7j-dtam.json")
    fun fetchLeadingDeathCauses() : Deferred<String?>
}