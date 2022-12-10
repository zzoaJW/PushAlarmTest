package com.z0o0a.pushalarmtest

import android.annotation.SuppressLint
import android.content.Context
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.z0o0a.pushalarmtest.databinding.ActivityMainBinding
import com.z0o0a.pushalarmtest.databinding.AlarmClickBinding

class AlarmClick  : AppCompatActivity() {
    private lateinit var binding : AlarmClickBinding

    private var defaultSound : Uri? = null
    private var ringtone : Ringtone? = null
    private var vibrator : Vibrator? = null

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ServiceCast", "InvalidWakeLockTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AlarmClickBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 효과음 발생
        defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        ringtone = RingtoneManager.getRingtone(this, defaultSound)
        ringtone.run { this!!.play() }

        // 진동 발생
        vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
        vibrator!!.vibrate(VibrationEffect.createWaveform(longArrayOf(500, 1000, 500, 1000), intArrayOf(0, 50, 0, 50), 0))

        binding.btnNotRide.setOnClickListener {
            ringtone.run { this!!.stop() }
            vibrator!!.cancel()
        }


    }
}