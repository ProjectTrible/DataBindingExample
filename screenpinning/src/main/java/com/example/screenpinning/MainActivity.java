package com.example.screenpinning;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.screenpinning.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements EventHandlers {

    private String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_main);
        Log.d(TAG, "onCreate: " + mainBinding.btMainPinning.getId());
//        mainBinding.btMainPinning.setOnClickListener(this);

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_main_pinning:
                startLockTask();
                break;
            case R.id.bt_main_un_pinning:
                stopLockTask();
                break;
        }

    }

   


}
