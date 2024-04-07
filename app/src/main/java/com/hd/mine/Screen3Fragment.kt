package com.hd.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hd.mine.databinding.FragScreen2Binding
import com.hd.mine.databinding.FragScreen3Binding

class Screen3Fragment : Fragment() {


    private var _binding: FragScreen3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragScreen3Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbar.setTitle(R.string.data_report)
            toolbar.setTitleTextColor(resources.getColor(R.color.black))
            toolbar.setNavigationIcon(R.drawable.backarraow)
            toolbar.setNavigationOnClickListener{
                findNavController().navigate(
                    Screen3FragmentDirections.actionScreen3FragmentToMainFragment()
                )

            }
        }
    }

}