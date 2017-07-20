package com.softard.wow.meterialdesign.recyclers;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softard.wow.meterialdesign.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wow on 17-7-20.
 */

public class RecyclerFragment1 extends Fragment {

    private static final String TAG = RecyclerFragment1.class.getSimpleName();

    @BindView(R.id.recycler_refresh) SwipeRefreshLayout mSRLayout;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_fragment, container, false);
        ButterKnife.bind(this, view);

        final RecyclerAdapter1 adapter = new RecyclerAdapter1(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mRecyclerView.setAdapter(adapter);

        mSRLayout.setColorSchemeResources(R.color.google_blue, R.color.google_green, R.color.google_red, R.color.google_yellow);
        mSRLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        if (color > 4) {
//                            color = 0;
//                        }
//                        adapter.setItems(++color);
                        mSRLayout.setRefreshing(false);
                    }
                }, 2300);

            }
        });


        return view;
    }
}
