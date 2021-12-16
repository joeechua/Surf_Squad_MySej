package com.example.basicapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class ReminderBroadcast extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        NotificationUtils notificationUtils = new NotificationUtils(context);
        NotificationCompat.Builder _builder = notificationUtils.setNotification("Testing", "Testing notification system");
        notificationUtils.getManager().notify(101, _builder.build());
    }
}