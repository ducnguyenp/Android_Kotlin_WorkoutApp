package com.example.sevenminuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.sevenminuteworkout.databinding.ActivityCountDownBinding
import com.example.sevenminuteworkout.databinding.ActivityExerciseBinding

class CountDownActivity : AppCompatActivity() {
    var binding: ActivityCountDownBinding? = null

    private var countDownTimer: CountDownTimer? = null
    private var timerDuration: Long = 60000
    private var pauseOffset: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountDownBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolBarCountDown)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolBarCountDown?.setNavigationOnClickListener() {
            onBackPressed()
        }

        setUp()
    }

    private fun setUp() {
        binding?.tvTimer?.text = "${(timerDuration / 1000).toString()}"
        binding?.btnStart?.setOnClickListener() {
            startTimer(pauseOffset)
        }
        binding?.btnPause?.setOnClickListener() {
            pauseTimer()
        }
        binding?.btnStop?.setOnClickListener() {
            resetTimer()
        }
    }

    private fun resetTimer() {
        if (countDownTimer !=null ) {
            countDownTimer!!.cancel()
            binding?.tvTimer?.text = "${(timerDuration / 1000).toString()}"
            countDownTimer = null
            pauseOffset = 0
        }
    }

    private fun pauseTimer() {
        if (countDownTimer!= null) {
            countDownTimer!!.cancel()
        }
    }

    private fun startTimer(pauseOffsetL: Long) {
        countDownTimer = object : CountDownTimer(timerDuration - pauseOffsetL, 1000) {
            override fun onTick(p0: Long) {
                pauseOffset = timerDuration - p0
                binding?.tvTimer?.text = (p0/1000).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@CountDownActivity, "Timer is finish", Toast.LENGTH_LONG).show()
            }
        }.start()
    }
}