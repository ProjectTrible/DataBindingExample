package com.example.yugandhar_pc.databindingexample;

import android.support.v7.widget.RecyclerView;

import com.example.yugandhar_pc.databindingexample.databinding.InflateRowItemBinding;

public class FlightViewHolder extends RecyclerView.ViewHolder {
       public   InflateRowItemBinding inflateRowItemBinding;


    public FlightViewHolder(InflateRowItemBinding inflateRowItemBinding) {
        super(inflateRowItemBinding.getRoot());
        this.inflateRowItemBinding = inflateRowItemBinding;

    }


}