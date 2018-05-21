package com.example.yugandhar_pc.databindingexample.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.yugandhar_pc.databindingexample.R;
import com.example.yugandhar_pc.databindingexample.databinding.ActivityViewBinding;
import com.example.yugandhar_pc.databindingexample.interfaces.LoginCallBack;
import com.example.yugandhar_pc.databindingexample.viewmodel.LoginViewModel;

public class ViewActivity extends AppCompatActivity implements LoginCallBack {
    ActivityViewBinding binding;
    LoginViewModel loginViewModel;
    private String TAG=ViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view);
        loginViewModel = new LoginViewModel(this);
        binding.setViewModel(loginViewModel);

    }

    @Override
    public void onScuccessCallBack() {
        Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFailureCallBack() {
        Toast.makeText(this,"Failure",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onFailureCallBack: "+loginViewModel.getFirstName());
        binding.tvCheckObservable.setText(loginViewModel.getFirstName());
    }
}

