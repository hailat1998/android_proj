package com.hd.mine

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hd.mine.databinding.FragScreen2Binding
import android.Manifest

class Screen2Fargment : Fragment() {

    private var _binding: FragScreen2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragScreen2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                binding.locationPermission.setImageResource(R.drawable.open)
            } else {
                binding.locationPermission.setImageResource(R.drawable.closed)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       binding.apply {
           toolbar.setTitle(R.string.permission)
           toolbar.setTitleTextColor(resources.getColor(R.color.black))
          toolbar.setNavigationIcon(R.drawable.backarraow)

           toolbar.setNavigationOnClickListener{
               findNavController().navigate(
       Screen2FargmentDirections.actionScreen2FargmentToMainFragment()
               )

           }
           locationPermission.setOnClickListener{
               when {
                   ContextCompat.checkSelfPermission(
                       requireContext(),
                       Manifest.permission.ACCESS_FINE_LOCATION
                   ) == PackageManager.PERMISSION_GRANTED -> {
                       locationPermission.setImageResource(R.drawable.open)
                   }

                   else -> {
                       requestPermissionLauncher.launch(
                           Manifest.permission.ACCESS_FINE_LOCATION )
                   }
               }
           }
       }
    }
}