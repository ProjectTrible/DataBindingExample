package com.example.notificationoreoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private NotificationHelper notificationHelper;
    private String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationHelper = new NotificationHelper(this,1 );

    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.button:
//                Toast.makeText(this, "check", Toast.LENGTH_SHORT).show();
                try {

                    notificationHelper.createNotification("title", "message");
                } catch (Exception e) {
                    Log.e(TAG, "buttonClick: "+e.getMessage() );
                }
                break;
        }
    }
}
