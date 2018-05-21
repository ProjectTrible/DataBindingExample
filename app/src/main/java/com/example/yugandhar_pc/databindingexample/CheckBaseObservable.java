package com.example.yugandhar_pc.databindingexample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class CheckBaseObservable extends BaseObservable {
    public String firstNameCHeck;
    private String lastName;
    private String Name;

    @Bindable
    public String getFirstNameCHeck() {
        return firstNameCHeck;
    }

    public void setFirstNameCHeck(String firstNameCHeck) {
        this.firstNameCHeck = firstNameCHeck;
        notifyChange();
//        notifyPropertyChanged(BR.firstNameCHeck);
        notifyPropertyChanged(R.id.observable_check_two);

}

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyChange();
        notifyPropertyChanged(BR.lastName);
    }
}
