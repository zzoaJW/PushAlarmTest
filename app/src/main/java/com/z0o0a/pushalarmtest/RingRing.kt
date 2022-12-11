package com.z0o0a.pushalarmtest

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.IBinder
import android.os.VibrationEffect
import android.os.Vibrator

@SuppressLint("NewApi")
class RingRing: Service() {

    private var defaultSound : Uri? = null
    private var ringtone : Ringtone? = null
    private var vibrator : Vibrator? = null

    companion object{
        private var isRunning = false

        fun isRunning():Boolean{
            return isRunning
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        isRunning = true

        defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        ringtone = RingtoneManager.getRingtone(this, defaultSound)

        vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

        ringtone.run { this!!.play() }
        vibrator!!.vibrate(VibrationEffect.createWaveform(longArrayOf(500, 1000, 500, 1000), intArrayOf(0, 50, 0, 50), 0))

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        isRunning = false

        ringtone!!.stop()
        vibrator!!.cancel()
    }
}