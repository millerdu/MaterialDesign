package com.softard.wow.meterialdesign.recyclers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.softard.wow.meterialdesign.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wow on 17-7-20.
 */

public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerAdapter1.RecyclerViewHolder> {

    private Context mContext;
    private List mItems;

    public RecyclerAdapter1(Context context) {
        this.mContext = context;
        mItems = new ArrayList();
        mItems.addAll(Arrays.asList(context.getResources().getStringArray(R.array.recycler_name_array)));
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.position = position;
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private int position;

        private RecyclerViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
    }
}
