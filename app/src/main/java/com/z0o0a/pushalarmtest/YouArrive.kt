package com.z0o0a.pushalarmtest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.z0o0a.pushalarmtest.databinding.YouArriveBinding

class YouArrive : AppCompatActivity() {
    private lateinit var binding : YouArriveBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = YouArriveBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnArriveOk.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}