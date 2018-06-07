package com.example.yugandhar_pc.databindingexample.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.example.yugandhar_pc.databindingexample.interfaces.LoginCallBack;
import com.example.yugandhar_pc.databindingexample.model.User;

public class LoginViewModel extends ViewModel {
    private String TAG = LoginViewModel.class.getSimpleName();
    private User user;
    private LoginCallBack loginCallBack;

    public LoginViewModel(LoginCallBack loginCallBack) {
        user = new User("", "","");
        this.loginCallBack=loginCallBack;
    }

    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e(TAG, "afterTextChanged: " + s.toString());
                user.setmEmail(s.toString());

            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setmPassword(s.toString());
            }
        };
    }

    public void checkLoginDetails(View view) {

        if (user.isInputDataValid()) {
            loginCallBack.onScuccessCallBack();
        } else {
            loginCallBack.onFailureCallBack();
        }

    }

    public String getFirstName() {
        Log.d(TAG, "getFirstName: "+user.getmFristName());
        return user.getmFristName();
    }
}
