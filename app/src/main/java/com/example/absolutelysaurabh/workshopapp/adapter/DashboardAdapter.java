package com.example.absolutelysaurabh.workshopapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.absolutelysaurabh.workshopapp.R;
import com.example.absolutelysaurabh.workshopapp.model.Workshop;
import com.example.absolutelysaurabh.workshopapp.viewHolder.AvailableWorkshopsViewHolder;
import com.example.absolutelysaurabh.workshopapp.viewHolder.DashboardViewHolder;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 25/1/18.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardViewHolder> {

    private static ArrayList<Workshop> al_workshops;

    private Context context;

    public DashboardAdapter(Context context, ArrayList<Workshop> al_workshops) {

        this.context = context;
        this.al_workshops = al_workshops;
    }

    @Override
    public DashboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DashboardViewHolder(LayoutInflater.from(parent.getContext()), parent, al_workshops);
    }

    @Override
    public void onBindViewHolder(DashboardViewHolder holder, int position) {

        try {

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.ic_launcher_background);
            requestOptions.error(R.drawable.ic_launcher_background);

            Glide.with(context).load(al_workshops.get(position).getUrl_to_image()).apply(requestOptions).thumbnail(0.5f).into(holder.picture);

            holder.title.setText(al_workshops.get(position).getTitle());
            holder.description.setText(al_workshops.get(position).getDescription());

        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        Log.e("position holder: ", String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return al_workshops.size();
    }
}

