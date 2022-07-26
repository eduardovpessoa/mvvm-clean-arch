package br.com.eduardovpessoa.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.eduardovpessoa.R
import br.com.eduardovpessoa.databinding.FragmentHomeBinding
import br.com.eduardovpessoa.util.AppConsts.Companion.IMG_HOME_URL
import coil.load

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgHome.load(IMG_HOME_URL) {
            crossfade(true)
        }
        binding.txtHome.setText(R.string.home_text)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}