package com.example.yugandhar_pc.databindingexample.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;

public class User extends BaseObservable {
    @NonNull
    private String mEmail;
    @NonNull
    private String mPassword;

    @Bindable
    @NonNull
    public String getmFristName() {
        return mFristName;

    }

    public void setmFristName(@NonNull String mFristName) {
        this.mFristName = mFristName;
        notifyChange();
    }

    @NonNull
    private String mFristName;

    public User(@NonNull String mEmail, @NonNull String mPassword, @NonNull String mFristName) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mFristName = mFristName;
    }

    @NonNull

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(@NonNull String mEmail) {
        this.mEmail = mEmail;
        notifyChange();
    }

    @NonNull
    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(@NonNull String mPassword) {
        this.mPassword = mPassword;
        notifyChange();
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getmEmail()) && Patterns.EMAIL_ADDRESS.matcher(getmEmail()).matches()
                && getmPassword().length() > 5;
    }
}
