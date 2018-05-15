package com.example.yugandhar_pc.databindingexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.yugandhar_pc.databindingexample.databinding.InflateRowItemBinding;

public class HeroViewHolder extends RecyclerView.ViewHolder {
    public InflateRowItemBinding itemView;
    public HeroViewHolder(InflateRowItemBinding itemView) {
        super(itemView.getRoot());
        this.itemView = itemView;
    }
}
