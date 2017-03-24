package com.example.deepjoshi.noti_big_img;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String title="Notification !!!";
//        int icon = R.drawable.index;
//        long when = System.currentTimeMillis();
//
//        Notification notification = new Notification(icon, title, when);
//
//        NotificationManager mNotificationManager =
//                (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//
//        RemoteViews contentView = new RemoteViews
//                (getPackageName(), R.layout.activity_main);
//        contentView.setImageViewResource(R.id.image,
//                R.drawable.index);
//        contentView.setTextViewText(R.id.title, title);
//        contentView.setTextViewText(R.id.text,
//                "This is a custom layout");
//        notification.contentView = contentView;
//
//        Intent notificationIntent = new Intent(this, MainActivity.class);
//        PendingIntent contentIntent = PendingIntent.getActivity(this,0,
//                notificationIntent, 0);
//        notification.contentIntent = contentIntent;
//
//        notification.flags |=
//               // Notification.FLAG_NO_CLEAR; //Do not clear  the notification
//        notification.defaults |= Notification.DEFAULT_LIGHTS; // LED
//        notification.defaults |= Notification.DEFAULT_VIBRATE;//Vibration
//        notification.defaults |= Notification.DEFAULT_SOUND; // Sound
//
//        mNotificationManager.notify(1, notification);
//}
//
      //  Bitmap w =BitmapFactory.decodeResource()
        Bitmap icon1 = BitmapFactory.decodeResource(getResources(),
                R.drawable.index);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                this).setAutoCancel(true)
                .setContentTitle("DJ-Android notification")
                .setSmallIcon(R.drawable.ic_android_black_24dp).setLargeIcon(icon1)
                .setContentText("Hello World!");

        NotificationCompat.BigPictureStyle bigPicStyle = new NotificationCompat.BigPictureStyle();
        bigPicStyle.bigPicture(icon1);
        bigPicStyle.setBigContentTitle("Deep ");
        mBuilder.setStyle(bigPicStyle);

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, MainActivity.class);

        // The stack builder object will contain an artificial back stack for
        // the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MainActivity.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // mId allows you to update the notification later on.
        mNotificationManager.notify(100, mBuilder.build());

    }
}
