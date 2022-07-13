package br.com.eduardovpessoa.ui.leadingdeathcauses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.eduardovpessoa.databinding.FragmentLeadingDeathCausesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LeadingDeathCausesFragment : Fragment() {

    private var _binding: FragmentLeadingDeathCausesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LeadingDeathCausesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeadingDeathCausesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchLeadingDeathCauses()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}