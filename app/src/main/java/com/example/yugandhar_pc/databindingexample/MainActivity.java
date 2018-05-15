package com.example.yugandhar_pc.databindingexample;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.yugandhar_pc.databindingexample.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivitymainBinding Layout File Name
        final ActivityMainBinding activityBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        List<String> hello = new ArrayList<>();
        hello.add("a");
        hello.add("c");
        Dellpers dellpers = new Dellpers("check", "e", hello, 40, false);
//        It is comming from Modle Class Name
//        binding the data
        activityBinding.setDellpers(dellpers);
        dellpers.setTitle("bb");
        Dellpers dellpersc = activityBinding.getDellpers();
//        Changes is are doing
        dellpers.title = "CC";
        Log.d(TAG, "onCreate: " + dellpersc.title);
        dellpers.setExcerpt(null);
        final CheckBaseObservable checkBaseObservable = new CheckBaseObservable();
        checkBaseObservable.setFirstName("heeloz/ksdfjal");
//        activityBinding.observablecheck.setText(checkBaseObservable.getFirstName());
        activityBinding.observableCheck.setText(checkBaseObservable.getFirstName());
        List<PojoFlightDetails> pojoFlightDetails = new ArrayList<>();
        PojoFlightDetails
                pojoFlightDetails1 = new PojoFlightDetails();
        pojoFlightDetails1.setFlightName("one");
        PojoFlightDetails
                pojoFlightDetails2 = new PojoFlightDetails();
        pojoFlightDetails2.setFlightName("Two");
        pojoFlightDetails.add(pojoFlightDetails1);
        pojoFlightDetails.add(pojoFlightDetails2);
        FlightAdapter flightAdapter = new FlightAdapter(this, pojoFlightDetails);
        activityBinding.rvlistCheck.setLayoutManager(new LinearLayoutManager(this));
        activityBinding.rvlistCheck.setAdapter(flightAdapter);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activityBinding.pbcheck.setVisibility(View.INVISIBLE);
                checkBaseObservable.setFirstName("Secound Name");
                activityBinding.observableCheck.setText(checkBaseObservable.getFirstName());
            }
        }, 2000);
    }
}
