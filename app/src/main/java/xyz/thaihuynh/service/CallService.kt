package xyz.thaihuynh.service

import androidx.lifecycle.ProcessLifecycleOwner
import android.content.Intent
import android.os.IBinder
import android.telecom.Call
import android.telecom.InCallService
import android.util.Log

class CallService : InCallService() {

    override fun onBind(intent: Intent?): IBinder? {
        Log.e(CallService.TAG, "onBind=========================================")
        return super.onBind(intent)
    }

    override fun onCallAdded(call: Call?) {
        super.onCallAdded(call)
        Log.e(CallService.TAG, "onCallAdded=========================================")
    }

    override fun onCallRemoved(call: Call?) {
        super.onCallRemoved(call)
        Log.e(CallService.TAG, "onCallRemoved=========================================")
    }

    companion object {
        private const val TAG = "CallService"
    }
}