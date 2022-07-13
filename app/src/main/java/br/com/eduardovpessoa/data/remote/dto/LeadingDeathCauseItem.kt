package br.com.eduardovpessoa.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LeadingDeathCauseItem(
    @SerialName("age_adjusted_death_rate")
    val ageAdjustedDeathRate: String? = "",
    @SerialName("death_rate")
    val deathRate: String? = "",
    @SerialName("deaths")
    val deaths: String? = "",
    @SerialName("leading_cause")
    val leadingCause: String? = "",
    @SerialName("race_ethnicity")
    val raceEthnicity: String? = "",
    @SerialName("sex")
    val sex: String? = "",
    @SerialName("year")
    val year: String? = ""
)