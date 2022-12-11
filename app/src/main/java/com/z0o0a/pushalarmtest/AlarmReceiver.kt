package com.z0o0a.pushalarmtest

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.ContextCompat.startForegroundService


class AlarmReceiver : BroadcastReceiver() {
    @SuppressLint("InvalidWakeLockTag")
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.d("Alarm Bell", "알람 발새앵")
        Toast.makeText(p0, "알람 발생", Toast.LENGTH_SHORT).show()

        val intent = Intent(p0, YouOk::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        p0!!.startActivity(intent)

//        val notificationIntent = Intent(p0, AlarmClick::class.java).apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        }
//        val pendingIntent: PendingIntent = PendingIntent.getActivity(p0, 0, notificationIntent, 0)

        val ringIntent = Intent(p0, RingRing::class.java)
        p0!!.startService(ringIntent)

        val fullScreenIntent = Intent(p0, YouOk::class.java)
        val fullScreenPendingIntent = PendingIntent.getActivity(p0, 0,
            fullScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        var builder = NotificationCompat.Builder(p0!!, "2000")
            .setSmallIcon(R.drawable.app_icon)
            .setContentTitle("알림 테스트 제목")
            .setContentText("내용내용내용")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//            .setContentIntent(pendingIntent)
//            .setAutoCancel(true)
            .setFullScreenIntent(fullScreenPendingIntent, true)

        with(NotificationManagerCompat.from(p0)) {
            notify(2000, builder.build())
        }


        val powerManager = p0!!.getSystemService(Context.POWER_SERVICE) as PowerManager

        val wakeLock = powerManager.newWakeLock(
            PowerManager.SCREEN_BRIGHT_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP or PowerManager.ON_AFTER_RELEASE,
            "WAKELOCK"
        )

        // wakeLock 실행 (화면 깨우기)
        wakeLock.acquire(5*60*1000L /*10 minutes*/)


    }
}