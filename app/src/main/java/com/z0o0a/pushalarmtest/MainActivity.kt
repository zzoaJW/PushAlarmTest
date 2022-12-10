package com.z0o0a.pushalarmtest

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.z0o0a.pushalarmtest.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private var inputTime = 0
    private var currentTime = "-"
    private var alarmTime = "-"

    val requestId = 2000

    private var alarmMgr: AlarmManager? = null
    private lateinit var alarmIntent: PendingIntent


    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCreateAlarm.setOnClickListener {
//            setValues()


            alarmMgr = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmIntent = Intent(this, AlarmReceiver::class.java).let { intent ->
                PendingIntent.getBroadcast(this, 0, intent, 0)
            }




//            alarmMgr?.set(
//                AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                SystemClock.elapsedRealtime() + 5*1000,
//                alarmIntent
//            )
        }


    }

    // 현재시간, 알람 울릴시간 전역변수에 저장
    fun setValues(){
        inputTime = binding.inputTime.text.toString().toInt()
        binding.inputTime2.text = inputTime.toString()

        currentTime = getCurrentTime()
        binding.currentTime.text = currentTime

        alarmTime = getAlarmTime(currentTime, inputTime)
        binding.alarmTime.text = alarmTime
    }

    // [현재 시간]을 "HH:mm:ss" 포맷으로 가져오기
    fun getCurrentTime():String{
        val now = System.currentTimeMillis()
        val ymd = SimpleDateFormat("HH:mm:ss", Locale.KOREAN).format(now)

        return ymd
    }
    // [알람 울릴시간] == 현재 시간 + n초 (입력한 알람 울릴 n초 뒤) 을 "HH:mm:ss" 포맷으로 가져오기
    fun getAlarmTime(ct:String, ipt:Int):String{
        val ymdList = ct.split(":")
        var hour = ymdList[0].toInt()
        var min = ymdList[1].toInt()
        var second = ymdList[2].toInt()

        second += ipt

        if (second>=60){
            min += second/60
            second %= 60
        }

        if (min>=60){
            hour += min/60
            min %= 60
        }

        if (hour>=24) {
            hour %= 24
        }

        var hourStr = String.format("%02d", hour)
        var minStr = String.format("%02d", min)
        var secondStr = String.format("%02d", second)

        return hourStr + ':' + minStr + ':' + secondStr
    }
}