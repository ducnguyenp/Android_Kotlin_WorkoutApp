package com.example.sevenminuteworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.sevenminuteworkout.StorageDataBase.HistoryApp
import com.example.sevenminuteworkout.StorageDataBase.HistoryDao
import com.example.sevenminuteworkout.StorageDataBase.HistoryEntity
import com.example.sevenminuteworkout.databinding.ActivityExerciseBinding
import com.example.sevenminuteworkout.databinding.ActivityFinishExerciseBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FinishExerciseActivity : AppCompatActivity() {
    private var binding: ActivityFinishExerciseBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarFinishActivity)

        if (supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarFinishActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        var historyDao = (application as HistoryApp).db.employeeDao()
        addHistory(historyDao)
        binding?.btnFinish?.setOnClickListener() {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    private fun addHistory (historyDao: HistoryDao)  {
        val date = Calendar.getInstance()
        val dateTime = date.time
        val sdf = SimpleDateFormat("dd MM yyyy HH:mm:ss", Locale.getDefault())
        val dateString = sdf.format(dateTime)
        lifecycleScope.launch {
            historyDao.insert(HistoryEntity(date = dateString))
        }
    }

}