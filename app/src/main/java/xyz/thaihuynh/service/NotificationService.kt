package xyz.thaihuynh.service

import android.app.Notification
import androidx.lifecycle.ProcessLifecycleOwner
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import android.app.PendingIntent
import android.app.Notification.Builder.recoverBuilder
import android.content.Context
import android.os.Build
import android.widget.RemoteViews





class NotificationService : NotificationListenerService() {

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        Log.e(TAG, "onNotificationPosted=========================================")
        Log.i(TAG, "onNotificationPosted=${ProcessLifecycleOwner.get().lifecycle.currentState}")
        logSbn(sbn)


    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        Log.e(TAG, "onNotificationRemoved=========================================")
    }

    private fun logSbn(sbn: StatusBarNotification) {
        Log.e(TAG, "getGroupKey=" + sbn.groupKey)
        Log.e(TAG, "getKey=" + sbn.key)
        Log.e(TAG, "getPackageName=" + sbn.packageName)
        Log.e(TAG, "getTag=" + sbn.tag)
        Log.e(TAG, "getId=" + sbn.id)
        Log.e(TAG, "getPostTime=" + sbn.postTime)
        Log.e(TAG, "getNotification.getGroup=" + sbn.notification.group)
        Log.e(TAG, "getNotification.getSortKey=" + sbn.notification.sortKey)
        Log.e(TAG, "getNotification.category=" + sbn.notification.category)
        if (sbn.notification.category == "call") {
            Log.e(TAG, "============== CALL HERE ===========")
            Log.e(TAG, "action size = " + sbn.notification.actions?.size)
            sbn.notification.actions?.forEach {action ->
                Log.e(TAG, "Action title = " + action.title)
            }
            getContentView(this, sbn.notification)?.let {
            }
        }
        sbn.notification
        Log.e(TAG, "getNotification.number=" + sbn.notification.number)
        Log.e(TAG, "getNotification.flags=" + sbn.notification.flags)
        Log.e(TAG, "getNotification.tickerText=" + sbn.notification.tickerText)
        Log.e(TAG, "getNotification.when=" + sbn.notification.`when`)
        Log.e(TAG, "getNotification.toString=" + sbn.notification.toString())
        for (key in sbn.notification.extras.keySet()) {
            Log.e(TAG, "getNotification.extras: key=$key, value=${sbn.notification.extras.get(key)}")
        }


    }

    fun getContentView(context: Context, notification: Notification): RemoteViews? {
        return if (notification.contentView != null)
            notification.contentView
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            Notification.Builder.recoverBuilder(context, notification).createContentView()
        else
            null
    }

    companion object {
        private const val TAG = "NotificationService"
    }
}
