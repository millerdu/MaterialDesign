package com.softard.wow.meterialdesign.recyclers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.softard.wow.meterialdesign.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by wow on 20/07/2017.
 */

public class StaggeredRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int ITEM_IMAGE = 0;
    private final static int ITEM_TEXT = 1;

    private Context mContext;
    private List<RecyclerImageModel> mImages;

    public StaggeredRecyclerAdapter(Context context, List<RecyclerImageModel> images) {
        this.mContext = context;
        this.mImages = images;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_IMAGE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_image, parent, false);
            return new ImageViewHolder(view);

        } else if (viewType == ITEM_TEXT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_text, parent, false);
            return new TextViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ImageViewHolder) {
            Picasso.with(mContext).load(mImages.get(position).getUrl()).into(((ImageViewHolder) holder).imageButton);
        } else if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).textView.setText("This is page " + mImages.get(position).getPage());
        }
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (!TextUtils.isEmpty(mImages.get(position).getUrl()))
            return ITEM_IMAGE;
        else
            return ITEM_TEXT;
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageButton imageButton;
        public ImageViewHolder(View itemView) {
            super(itemView);
            imageButton = (ImageButton) itemView.findViewById(R.id.recycler_item_imagebutton);
        }
    }

    class TextViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public TextViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recycler_item_textview);
        }
    }

}
