package com.softard.wow.meterialdesign.recyclers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wow on 20/07/2017.
 */

public class StaggeredRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private Context mContext;
    private List<RecyclerImageModel> mImages;

    public StaggeredRecyclerAdapter(Context context, List<RecyclerImageModel> images) {
        this.mContext = context;
        this.mImages = images;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
