package com.z0o0a.pushalarmtest

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
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

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ServiceCast", "InvalidWakeLockTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AlarmClickBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




    }

//    @SuppressLint("NewApi")
//    override fun onResume() {
//        super.onResume()
//
//        if (RingRing.isRunning()){
//            val intent = Intent(this, YouOk::class.java)
//            startActivity(intent)
//        }
//    }
}