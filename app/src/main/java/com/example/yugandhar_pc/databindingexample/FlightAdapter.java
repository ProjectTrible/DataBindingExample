package com.example.yugandhar_pc.databindingexample;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yugandhar_pc.databindingexample.databinding.InflateRowItemBinding;

import java.util.List;

public class FlightAdapter extends RecyclerView.Adapter<FlightViewHolder> implements OnItemClick
        {
    //    private List<Flight> flightsList;
    private Context context;
    private List<PojoFlightDetails> list;
    private String TAG=FlightAdapter.class.getSimpleName();

    public FlightAdapter(Context context, List<PojoFlightDetails> pojoFlightDetails) {
        this.context = context;
        this.list = pojoFlightDetails;
    }


    @NonNull
    @Override
    public FlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//Databinding row layout example
        InflateRowItemBinding inflateRowItemBinding = DataBindingUtil.inflate(LayoutInflater.from
                (context), R.layout.inflate_row_item, parent, false);
        FlightViewHolder flightViewHolder = new FlightViewHolder(inflateRowItemBinding);
        return flightViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FlightViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: "+list.get(position).getFlightName());
        holder.inflateRowItemBinding.flightname.setText(list.get(position).getFlightName().toString());
        holder.inflateRowItemBinding.flightbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnItemClickListener(position);
            }
        });
                                        
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public void OnItemClickListener(int position) {
        Toast.makeText(context, ""+list.get(position).getFlightName(), Toast.LENGTH_SHORT).show();
    }
}
