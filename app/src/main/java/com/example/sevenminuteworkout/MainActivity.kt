package com.example.sevenminuteworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sevenminuteworkout.StorageDataBase.HistoryActivity
import com.example.sevenminuteworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root) // Todo: root is the xml of the mainActivity

        // Todo: want to add the lib, go to the bundle and add { android: ....buildFeatures { viewBinding = true }}
        // Todo: now having binding, I can access to the xml element without get it
        binding?.flStart?.setOnClickListener() {
        // Todo: When you want to hide the bar, go to themes.xml and change file to Theme.MaterialComponents.DayNight.NoActionBar
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        binding?.goToTextToSpeechBtn?.setOnClickListener() {
            val intent = Intent(this, TextToSpechActivity::class.java)
            startActivity(intent)
        }
        binding?.goToRecyclerViewBtn?.setOnClickListener() {
            val intent = Intent(this, RecyclerListView::class.java)
            startActivity(intent)
        }
        binding?.flBMI?.setOnClickListener() {
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }
        binding?.flHistory?.setOnClickListener() {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null // Todo: destroy it when finish, avoid memory leak
    }
}