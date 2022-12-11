package com.z0o0a.pushalarmtest

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity
import com.z0o0a.pushalarmtest.databinding.YouOkBinding

class YouOk : AppCompatActivity() {
    private lateinit var binding : YouOkBinding


    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = YouOkBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnTransOk.setOnClickListener {
            // 소리, 진동 종료
            val stopRingServiceIntent = Intent(this, RingRing::class.java)
            stopService(stopRingServiceIntent)

            // push알림 자동 삭제
            val notification = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notification.cancelAll()

            intent = Intent(this, AlarmClick::class.java)
            startActivity(intent)
        }
    }
}