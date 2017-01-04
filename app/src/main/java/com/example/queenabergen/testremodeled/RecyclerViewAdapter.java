package com.example.queenabergen.testremodeled;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by queenabergen on 1/3/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    List<Animal> animals;
    LayoutInflater layoutInflater;

    public RecyclerViewAdapter (List<Animal> animals, Context context){
        layoutInflater = LayoutInflater.from(context);
        this.animals = animals;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.viewholder, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.bind(animals.get(position));
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }
}
