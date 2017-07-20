package com.softard.wow.meterialdesign.recyclers;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softard.wow.meterialdesign.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wow on 20/07/2017.
 */

public class StaggeredRecyclerFragment extends Fragment {

    @BindView(R.id.recycler_refresh) SwipeRefreshLayout mSRLayout;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
