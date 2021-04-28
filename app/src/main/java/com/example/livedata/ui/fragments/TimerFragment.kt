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


class timer_fragment : Fragment(){
    private val viewModel by activityViewModels<MainViewModel>()
    private var _binding: FragmentTimerFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTimerFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        viewModel.seconds().observe(viewLifecycleOwner, Observer {
            binding.timeCustomSeconds.text = it.toString()
        })

        viewModel.finished.observe(viewLifecycleOwner, Observer {
            if(it){
                Toast.makeText(activity,"finished",Toast.LENGTH_SHORT).show()
            }
        })

        binding.startButton.setOnClickListener(View.OnClickListener {
            if(binding.timeEditor.text.isEmpty() || binding.timeEditor.text.length<4){
                Toast.makeText(activity,"Invalid", Toast.LENGTH_SHORT).show()
            }
            else{

                viewModel.timerValue.value = binding.timeEditor.text.toString().toLong()
            }
            viewModel.startTimer()
        })

        binding.stopButton.setOnClickListener(View.OnClickListener {
            binding.timeCustomSeconds.text = "0"
            viewModel.stopTimer()
        })

        return view

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    }
