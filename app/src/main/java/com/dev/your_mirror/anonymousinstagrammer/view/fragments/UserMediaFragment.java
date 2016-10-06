package com.dev.your_mirror.anonymousinstagrammer.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dev.your_mirror.anonymousinstagrammer.R;
import com.dev.your_mirror.anonymousinstagrammer.presenter.UserMediaPresenter;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Comment;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMedia;
import com.dev.your_mirror.anonymousinstagrammer.view.adapters.RecentMediaCommentListAdapter;

import java.util.List;

public class UserMediaFragment extends BaseFragment {
    public static final String TAG = "UserMediaFragment";
    public static final String RECENT_MEDIA = "RecentMedia";

    private UserMediaPresenter userMediaPresenter;
    private RecyclerView commentsRecyclerView;
    private ImageView mediaPost;
    private RecentMediaCommentListAdapter commentsAdapter;

    @Override
    public UserMediaPresenter getPresenter() {
        return userMediaPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_user_media,  container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews();
        initUserMediaPresenter();
        afterInitViews();
    }

    protected void initUserMediaPresenter() {
        Bundle bundle = getArguments();

        RecentMedia recentMedia = bundle.getParcelable(RECENT_MEDIA);
        userMediaPresenter = new UserMediaPresenter(this, recentMedia);
    }

    protected void initViews() {
        mediaPost = (ImageView) getActivity().findViewById(R.id.user_media_post);
        commentsRecyclerView = (RecyclerView) getActivity().findViewById(R.id.user_media_recycle);
        commentsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        commentsAdapter = new RecentMediaCommentListAdapter(
            getContext(),
            commentsRecyclerView,
            () -> getPresenter().onScrollCommentsView()
        );
        commentsRecyclerView.setAdapter(commentsAdapter);
    }

    protected void afterInitViews() {
        getPresenter().onScrollCommentsView();
    }

    public void setPostImage(String url) {
        Glide.with(mediaPost.getContext()).load(url).into(mediaPost);
    }

    public void updateRecentMediaAdapter(List<Comment> commentList) {
        commentsAdapter.addItems(commentList);
    }

    public void showError(String title, String message) {
        new AlertDialog.Builder(getActivity())
            .setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(R.string.ok, (dialogInterface, i) -> {})
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show();
    }

    public void showRecentMediaProgressBar() {
        commentsAdapter.showProgressBar();
    }

    public void hideRecentMediaProgressBar() {
        commentsAdapter.hideProgressBar();
    }
}
