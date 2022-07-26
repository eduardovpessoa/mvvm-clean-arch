package br.com.eduardovpessoa.data.remote.leadingdeathcauses

import br.com.eduardovpessoa.data.remote.dto.DesignTemplateItem
import br.com.eduardovpessoa.util.AppConsts.Companion.TOKEN
import java.util.Base64
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LeadingDeathCausesRepository(
    private val api: LeadingDeathCausesApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun fetchLeadingDeathCausesAsync(): Response<DesignTemplateItem> {
        return withContext(dispatcher) {
            api.fetchLeadingDeathCausesAsync(
                String(Base64.getDecoder().decode(TOKEN.plus("==")))
            )
        }
    }
}