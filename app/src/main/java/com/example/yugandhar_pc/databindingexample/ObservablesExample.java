package com.example.yugandhar_pc.databindingexample;

import android.app.VoiceInteractor;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yugandhar_pc.databindingexample.Check.HeroesBean;
import com.example.yugandhar_pc.databindingexample.databinding.ActivityObservablesExampleBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ObservablesExample extends AppCompatActivity {

    private String TAG = ObservablesExample.class.getSimpleName();
    Check check;
    ActivityObservablesExampleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout
                .activity_observables_example);
        check = new Check();
        apiCall();

    }

    private void apiCall() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://simplifiedcoding.net/demos/view-flipper/heroes.php", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e(TAG, "onResponse: " + response);
                try {
                    JSONArray jsonArray = response.getJSONArray("heroes");

                    List<HeroesBean> beanList = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        HeroesBean heroesBean = new HeroesBean();
                        heroesBean.setName(jsonArray.getJSONObject(i).getString("name"));
                        beanList.add(heroesBean);
                        Log.d(TAG, "onResponse: " + jsonArray.getJSONObject(i).getString("name"));
                    }
                    check.setHeroes(beanList);
                    Log.e(TAG, "onResponse: size"+check.getHeroes().size() );
                    setAdapterCheck();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: " + error.getMessage());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }

    private void setAdapterCheck() {
                RecyclerCheckAdapter recyclerCheckAdapter = new RecyclerCheckAdapter(this, check.getHeroes());
        binding.rvlistCheckDemo.setLayoutManager(new LinearLayoutManager(this));
        binding.rvlistCheckDemo.setAdapter(recyclerCheckAdapter);

    }
}
