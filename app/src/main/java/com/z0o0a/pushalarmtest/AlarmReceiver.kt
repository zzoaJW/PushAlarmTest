package com.z0o0a.pushalarmtest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi


class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.d("Alarm Bell", "알람 발새앵")
        Toast.makeText(p0, "알람 발생", Toast.LENGTH_SHORT).show()

        val intent = Intent(p0, AlarmClick::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        p0!!.startActivity(intent)
    }
}