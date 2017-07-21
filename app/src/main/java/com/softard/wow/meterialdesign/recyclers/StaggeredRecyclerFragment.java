package com.softard.wow.meterialdesign.recyclers;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softard.wow.meterialdesign.R;
import com.softard.wow.meterialdesign.internet.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wow on 20/07/2017.
 */

public class StaggeredRecyclerFragment extends Fragment {

    @BindView(R.id.recycler_refresh) SwipeRefreshLayout mSRLayout;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    private int mShowPage = 1;
    private List<RecyclerImageModel> mImages = null;
    private StaggeredRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_fragment, container, false);
        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mSRLayout.setColorSchemeResources(R.color.google_blue, R.color.google_green,
                                          R.color.google_red, R.color.google_yellow);
        mSRLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mShowPage = 1;
                new GetDataTask().execute("http://gank.io/api/data/福利/10/1");
            }
        });

        new GetDataTask().execute("http://gank.io/api/data/福利/10/1");
        return view;
    }



    private class GetDataTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return HttpUtils.get(params[0]);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mSRLayout.setRefreshing(true);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (!TextUtils.isEmpty(s)) {
                JSONObject jsonObject;
                String jsonString = null;
                Gson gson = new Gson();

                try {
                    jsonObject = new JSONObject(s);
                    jsonString = jsonObject.getString("results");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (mImages == null || mImages.size() == 0) {
                    mImages = gson.fromJson(jsonString,
                            new TypeToken<List<RecyclerImageModel>>(){}.getType());
                    RecyclerImageModel rim = new RecyclerImageModel();
                    rim.setPage(mShowPage);
                    mImages.add(rim);
                } else {
                    List<RecyclerImageModel> imgs = gson.fromJson(jsonString,
                            new TypeToken<List<RecyclerImageModel>>(){}.getType());
                    mImages.addAll(imgs);

                    RecyclerImageModel rim = new RecyclerImageModel();
                    rim.setPage(mShowPage);
                    mImages.add(rim);
                }

                if (mAdapter == null) {
                    mAdapter = new StaggeredRecyclerAdapter(getContext(), mImages);
                    mRecyclerView.setAdapter(mAdapter);
                } else {
                    mAdapter.notifyDataSetChanged();
                }

            }
            mSRLayout.setRefreshing(false);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }

}
