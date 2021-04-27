package com.example.livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.livedata.databinding.FragmentHomeFragmentBinding


class home_fragment : Fragment() {
    private var _binding: FragmentHomeFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<MainViewModel>()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeFragmentBinding.inflate(inflater, container, false)

        binding.customTime.setOnClickListener(View.OnClickListener {
             findNavController().navigate(R.id.action_home_fragment_to_timer_fragment)
        })
        return binding.root

    }


    }
