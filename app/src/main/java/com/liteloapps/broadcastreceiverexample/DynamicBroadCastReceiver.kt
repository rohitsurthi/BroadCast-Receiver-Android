package com.liteloapps.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class DynamicBroadCastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        when(intent?.action) {

            Intent.ACTION_TIME_TICK -> {
                Toast.makeText(context, "Time Changed by 1 Minute", Toast.LENGTH_LONG).show()
            }

            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val isAirPlaneModeEnabled = intent?.getBooleanExtra("state", false)
                if(isAirPlaneModeEnabled == true) {
                    Toast.makeText(context, "Airplane mode enabled", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Airplane mode disabled", Toast.LENGTH_LONG).show()
                }
            }

        }
    }

}