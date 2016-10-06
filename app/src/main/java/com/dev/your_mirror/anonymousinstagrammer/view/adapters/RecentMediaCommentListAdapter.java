package com.dev.your_mirror.anonymousinstagrammer.view.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dev.your_mirror.anonymousinstagrammer.R;
import com.dev.your_mirror.anonymousinstagrammer.custom.adapter.RecyclerViewProgressAdapter;
import com.dev.your_mirror.anonymousinstagrammer.custom.glide.CircleTransform;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Comment;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMedia;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Resolution;

import java.util.Map;

public class RecentMediaCommentListAdapter extends RecyclerViewProgressAdapter<Comment> {
    CircleTransform circleTransform;


    public RecentMediaCommentListAdapter(Context context, RecyclerView recyclerView, OnLoadMoreListener onLoadMoreListener) {
        super(recyclerView, onLoadMoreListener);
        circleTransform = new CircleTransform(context);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView userAvatar;
        public TextView comment;
        private CircleTransform circleTransform;

        public ItemViewHolder(View view, CircleTransform circleTransform) {
            super(view);
            userAvatar = (ImageView) view.findViewById(R.id.recent_media_comment_user_avatar);
            comment = (TextView) view.findViewById(R.id.recent_media_comment_text);
            this.circleTransform = circleTransform;
        }

        public void setText(String text) {
            comment.setText(text);
        }

        public void setImageUrl(String url) {
            Glide.with(userAvatar.getContext()).load(url).transform(circleTransform)
                .into(userAvatar);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_media, parent, false),
            circleTransform
        );
    }

    @Override
    public void onBindItemView(RecyclerView.ViewHolder genericHolder, int position) {
        Comment comment = dataSet.get(position);
        ItemViewHolder viewHolder = (ItemViewHolder) genericHolder;
        viewHolder.setText(comment.getText());
        viewHolder.setImageUrl(comment.getFrom().getProfilePicture());
    }
}
