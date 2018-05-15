package com.example.yugandhar_pc.databindingexample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.yugandhar_pc.databindingexample.databinding.InflateRowItemBinding;

import java.util.List;

public class RecyclerCheckAdapter extends RecyclerView.Adapter<HeroViewHolder> {
    private Context context;
    private List<Check.HeroesBean> beans;


    public RecyclerCheckAdapter(Context context, List<Check.HeroesBean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
      InflateRowItemBinding heroViewHolder=  DataBindingUtil.inflate(layoutInflater, R.layout
                      .inflate_row_item, parent,
                false);
        HeroViewHolder flightViewHolder = new HeroViewHolder(heroViewHolder);
        return flightViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        holder.itemView.flightname.setText(beans.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return beans.size();

    }


}
