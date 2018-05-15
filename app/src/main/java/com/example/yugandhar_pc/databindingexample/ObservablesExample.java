package com.example.yugandhar_pc.databindingexample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yugandhar_pc.databindingexample.databinding.ActivityObservablesExampleBinding;

public class ObservablesExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_observables_example);
        ActivityObservablesExampleBinding binding = DataBindingUtil.setContentView(this, R.layout
                .activity_observables_example);
    }
}
