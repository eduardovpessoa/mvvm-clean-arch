package br.com.eduardovpessoa.ui.leadingdeathcauses

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.eduardovpessoa.data.remote.dto.LeadingDeathCause
import br.com.eduardovpessoa.domain.GetLeadingDeathCausesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LeadingDeathCausesViewModel(
    private val getLeadingDeathCausesUseCase: GetLeadingDeathCausesUseCase
) : ViewModel() {
    private val _leadingDeathCauses = MutableStateFlow(listOf<LeadingDeathCause>())
    val leadingDeathCauses: StateFlow<List<LeadingDeathCause>>
        get() = _leadingDeathCauses

    internal fun fetchLeadingDeathCauses() {
        viewModelScope.launch {
            val result = getLeadingDeathCausesUseCase()
            result.let {
                _leadingDeathCauses.update { it }
                Log.i("test", it.toString())
            }
        }
    }
}