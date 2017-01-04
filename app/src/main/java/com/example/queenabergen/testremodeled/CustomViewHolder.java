package com.example.queenabergen.testremodeled;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by queenabergen on 1/3/17.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public CustomViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.textView);

    }

    public void bind(Animal animal) {
        title.setText(animal.getName());
        title.setTextColor(Color.parseColor(animal.getTextColor()));
        title.setBackgroundColor(Color.parseColor(animal.getBackground()));

    }
}
