package com.z0o0a.pushalarmtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.z0o0a.pushalarmtest.databinding.ActivityMainBinding
import com.z0o0a.pushalarmtest.databinding.AlarmClickBinding

class AlarmClick  : AppCompatActivity() {
    private lateinit var binding : AlarmClickBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AlarmClickBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}