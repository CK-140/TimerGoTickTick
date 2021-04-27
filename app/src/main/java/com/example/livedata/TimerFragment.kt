package com.example.livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.livedata.databinding.FragmentHomeFragmentBinding
import com.example.livedata.databinding.FragmentTimerFragmentBinding


class timer_fragment : Fragment(R.layout.fragment_timer_fragment){
    private val viewModel by activityViewModels<MainViewModel>()
    private var _binding: FragmentTimerFragmentBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTimerFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.startTimer()

        viewModel.seconds().observe(this, Observer {
            binding.timeCustomSeconds.text = it.toString()
        })

        viewModel.finished.observe(this, Observer {
            if(it){
                Toast.makeText(activity,"finished",Toast.LENGTH_SHORT).show()
            }
        })

    }

    }
