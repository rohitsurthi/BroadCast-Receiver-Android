package com.liteloapps.broadcastreceiverexample

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var airPlaneModeBroadcastReceiver: DynamicBroadCastReceiver
    lateinit var timeBroadCastReceiver: DynamicBroadCastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        airPlaneModeBroadcastReceiver = DynamicBroadCastReceiver()
        timeBroadCastReceiver = DynamicBroadCastReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also { intentFilter ->
            registerReceiver(airPlaneModeBroadcastReceiver, intentFilter)
        }

        IntentFilter(Intent.ACTION_TIME_TICK).also { intentFilter ->
            registerReceiver(timeBroadCastReceiver, intentFilter)
        }
    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(airPlaneModeBroadcastReceiver)
        unregisterReceiver(timeBroadCastReceiver)
    }
}