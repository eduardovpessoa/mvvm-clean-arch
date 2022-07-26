package br.com.eduardovpessoa.ui.leadingdeathcauses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.eduardovpessoa.data.remote.dto.DesignTemplateItem
import br.com.eduardovpessoa.domain.GetLeadingDeathCausesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LeadingDeathCausesViewModel(
    private val getLeadingDeathCausesUseCase: GetLeadingDeathCausesUseCase
) : ViewModel() {
    private val _errorWhenFetchingData = MutableStateFlow("")
    val errorWhenFetchingData: StateFlow<String>
        get() = _errorWhenFetchingData

    private val _leadingDeathCauses = MutableStateFlow(DesignTemplateItem())
    val leadingDeathCauses: StateFlow<DesignTemplateItem>
        get() = _leadingDeathCauses

    internal fun fetchLeadingDeathCauses() {
        viewModelScope.launch {
            getLeadingDeathCausesUseCase().run {
                if (isSuccessful) {
                    body()?.let { dti ->
                        _leadingDeathCauses.value = dti
                        return@run
                    }
                }
                _errorWhenFetchingData.update { "There was an error trying to fetch the data!" }
            }
        }
    }

    internal fun clearErrorMessage() {
        _errorWhenFetchingData.update { "" }
    }
}