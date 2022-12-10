package com.z0o0a.pushalarmtest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast


class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.d("Alarm Bell", "알람 발새앵")

        Toast.makeText(p0, "알람 발생", Toast.LENGTH_SHORT).show()
    }
}