package br.com.eduardovpessoa.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias DesignTemplateItem = ArrayList<DesignTemplateItemElement>

@Serializable
data class DesignTemplateItemElement(
    val year: String? = null,

    @SerialName("leading_cause")
    val leadingCause: String? = null,

    val sex: String? = null,

    @SerialName("race_ethnicity")
    val raceEthnicity: String? = null,

    val deaths: String? = null,

    @SerialName("death_rate")
    val deathRate: String? = null,

    @SerialName("age_adjusted_death_rate")
    val ageAdjustedDeathRate: String? = null
)
