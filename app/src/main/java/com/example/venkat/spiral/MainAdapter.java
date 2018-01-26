package com.example.venkat.spiral;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by venkat on 27/1/18.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    LayoutInflater inflater;
    HashMap<String,String> Slots2;

    public MainAdapter(Context context, HashMap<String,String> Slots2) {
        this.inflater = LayoutInflater.from(context);
        this.Slots2 = Slots2;
    }

    public MainAdapter(HashMap<String, String> slots2) {
        this.Slots2=slots2;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        //holder.bindData();
        holder.timeSlot.setText(Slots2.get("10-11")); // value for the given key
    }

    @Override
    public int getItemCount() {
        return Slots2.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        TextView timeSlot, boolRes;

        public MainViewHolder(View itemView) {
            super(itemView);
            timeSlot = (TextView) itemView.findViewById(R.id.timeSlot);
            boolRes = (TextView) itemView.findViewById(R.id.boolRes);
        }

    }
}
