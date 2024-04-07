package com.hd.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hd.mine.databinding.MainFragBinding

class MainFragment : Fragment() {
    private var _binding : MainFragBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbar.setTitle(R.string.app_name)
            toolbar.setTitleTextColor(resources.getColor(R.color.black))
            permission.setOnClickListener{
                findNavController().navigate(
                    MainFragmentDirections.main2screen2()
                )
            }
            dataReport.setOnClickListener {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToScreen3Fragment())
            }
        }

    }
}