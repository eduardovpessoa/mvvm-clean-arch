package br.com.eduardovpessoa.ui.leadingdeathcauses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.eduardovpessoa.databinding.FragmentLeadingDeathCausesBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
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
        binding.recyclerDeathCauses.layoutManager = LinearLayoutManager(view.context)
        binding.recyclerDeathCauses.addItemDecoration(
            DividerItemDecoration(
                view.context,
                DividerItemDecoration.VERTICAL
            )
        )

        //Request the data
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.fetchLeadingDeathCauses()
        }

        //Collects the data
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.leadingDeathCauses.collect { list ->
                if (!list.isNullOrEmpty()) {
                    binding.recyclerDeathCauses.adapter = LeadingDeathCausesAdapter(list)
                }
            }
        }

        //Displays an error message
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.errorWhenFetchingData.collect {
                if (it.isNotEmpty()) {
                    Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
                    viewModel.clearErrorMessage()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}