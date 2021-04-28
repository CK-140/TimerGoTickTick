package com.example.livedata

import android.os.CountDownTimer
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private lateinit var timer: CountDownTimer
    var timerValue = MutableLiveData<Long>()
    var finished = MutableLiveData<Boolean>()
    private val _seconds = MutableLiveData<Int>()
    fun seconds(): LiveData<Int>{
        return _seconds
    }
    fun finish(): LiveData<Boolean>{
        return  finished
    }
    fun startTimer(){
        timer = object: CountDownTimer(timerValue.value!!.toLong(),1000){
            override fun onTick(p0: Long) {
                val timerLeft = p0/1000
                _seconds.value = timerLeft.toInt()
            }

            override fun onFinish() {
                finished.value = true
            }
        }.start()
    }
    fun stopTimer(){
        timer.cancel()
    }
    fun naviToCustom(){

    }
    fun naviToCovid(){

    }
    fun naviToQuickie(){
        
    }

}