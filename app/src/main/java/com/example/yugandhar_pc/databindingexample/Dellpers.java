package com.example.yugandhar_pc.databindingexample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

import java.util.List;

/**
 * Model Class For DataByinding
 */
public class Dellpers /*extends BaseObservable*/ {
    public String title="Check";
    private String excerpt;
    public boolean highlight;
    private String imageUrl;
    private int commentsNumber;
    private boolean read;
    public List<String> check;
    public int age;

    public Dellpers(String title, String excerpt, List<String> hell,int age,boolean highlight) {
        this.title = title;
        this.excerpt = excerpt;
        this.highlight = highlight;
        this.imageUrl = imageUrl;
        this.commentsNumber = commentsNumber;
        this.read = false;
        this.check = hell;
        this.age = age;
    }

    public View.OnClickListener clickListenerCheck() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Hello", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public void methodReference(View view) {
        this.title = "hello";
    }
}
