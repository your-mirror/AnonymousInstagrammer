package com.dev.your_mirror.anonymousinstagrammer.view.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dev.your_mirror.anonymousinstagrammer.R;
import com.dev.your_mirror.anonymousinstagrammer.custom.adapter.RecyclerViewProgressAdapter;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMedia;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Resolution;

import java.util.Map;

public class RecentMediaListAdapter extends RecyclerViewProgressAdapter<RecentMedia> {
    private View.OnClickListener onItemClickListener;

    public RecentMediaListAdapter(RecyclerView recyclerView, OnLoadMoreListener onLoadMoreListener) {
        super(recyclerView, onLoadMoreListener);
    }

    public RecentMediaListAdapter(RecyclerView recyclerView, OnLoadMoreListener onLoadMoreListener,
                                  View.OnClickListener onItemClickListener) {
        super(recyclerView, onLoadMoreListener);
        this.onItemClickListener = onItemClickListener;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;

        public ItemViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.user_media_thumbnail);
        }

        public void setImageUrl(String url) {
            Glide.with(thumbnail.getContext()).load(url).into(thumbnail);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_user_media, parent, false);
        if (onItemClickListener != null) {
            view.setOnClickListener(onItemClickListener);
        }
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);

        return itemViewHolder;
    }

    @Override
    public void onBindItemView(RecyclerView.ViewHolder genericHolder, int position) {
        RecentMedia recentMedia = dataSet.get(position);
        Map<Resolution.TYPE, Resolution> images = recentMedia.getImages();
        ((ItemViewHolder) genericHolder).setImageUrl(images.get(Resolution.TYPE.THUMBNAIL).getUrl());
    }
}
