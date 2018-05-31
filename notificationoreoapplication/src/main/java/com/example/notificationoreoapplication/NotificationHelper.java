package com.example.notificationoreoapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;


public class NotificationHelper {
    private static final String TAG = NotificationHelper.class.getSimpleName();
    private Context context;
    private final String CHANNEL_ID = "channel_1";
    private final String CHANNEL_NAME = "Channel Name";
    private final int notification_id = 1;
    private int id;

    public NotificationHelper(Context context, int id) {
        this.context = context;
        this.id = id;

    }


    public void createNotification(String title, String message) {
//        Creating Notification Builder
        NotificationCompat.Builder builderNotification = new NotificationCompat.Builder(context,
                CHANNEL_ID);      int notificationid=(int)Math.random();
        id++;
        builderNotification.setAutoCancel(false);
        builderNotification.setContentTitle(title+id);
        builderNotification.setContentText(message+id);
        builderNotification.setSmallIcon(R.drawable.ic_launcher_background);
//        Notification Manager Creation
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        it will work only only from Orieo
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME
                    , NotificationManager.IMPORTANCE_HIGH);
//            notificationChannel.canShowBadge();
//            notificationChannel.canBypassDnd();
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            builderNotification.setChannelId(CHANNEL_ID);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManager.notify(notificationid, builderNotification.build());

        


    }
}
