package com.example.sevenminuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
import com.example.sevenminuteworkout.databinding.ActivityTextToSpechBinding
import java.util.*

class TextToSpechActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private var binding: ActivityTextToSpechBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextToSpechBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        tts = TextToSpeech(this, this)

        binding?.btnSpeak?.setOnClickListener { view ->

            if (binding?.etEnteredText?.text!!.isEmpty()) {
                Toast.makeText(
                    this@TextToSpechActivity,
                    "Enter a text to speak.",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                speakOut(binding?.etEnteredText?.text.toString())
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "The Language specified is not supported!")
            }

        } else {
            Log.e("TTS", "Initialization Failed!")
        }
    }

    public override fun onDestroy() {

        if (tts != null) {
            tts?.stop()
            tts?.shutdown()
        }

        super.onDestroy()
    }

    private fun speakOut(text: String) {
        // Todo: QUEUE_FLUSH will remove the past voice then you click the new one
        // Todo: QUEUE_ADD will add to queue and run sequentially
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }
}