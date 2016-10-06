package com.dev.your_mirror.anonymousinstagrammer.view.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.your_mirror.anonymousinstagrammer.R;
import com.dev.your_mirror.anonymousinstagrammer.custom.recycle_view.SpacingDecoration;
import com.dev.your_mirror.anonymousinstagrammer.presenter.UserMediaListPresenter;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMedia;
import com.dev.your_mirror.anonymousinstagrammer.view.adapters.RecentMediaListAdapter;

import java.util.List;

public class UserMediaListFragment extends BaseFragment {
    public static final String TAG = "UserMediaListFragment";
    public final int GRID_SPAN_COUNT = 3;

    private UserMediaListPresenter userMediaListPresenter;
    private RecyclerView userMediaRecyclerView;
    private RecentMediaListAdapter recentMediaListAdapter;
    private OnUserMediaItemSelectedListener onSelectUserMediaItemListener;

    public interface OnUserMediaItemSelectedListener {
        public void onItemSelected(RecentMedia recentMedia);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (getActivity() != null) {
            onSelectUserMediaItemListener = (OnUserMediaItemSelectedListener) getActivity();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_list_user_media,  container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews();
        initUserListMediaPresenter(getActivity().getIntent().getExtras());
        afterInitViews();
    }

    protected void initViews() {
        userMediaRecyclerView = (RecyclerView) getActivity().findViewById(R.id.list_user_media_recycle);
        userMediaRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), GRID_SPAN_COUNT));
        recentMediaListAdapter = new RecentMediaListAdapter(
                userMediaRecyclerView,
                () -> getPresenter().onScrollUserMediaGridView(),
                view -> {
                    int position = userMediaRecyclerView.indexOfChild(view);
                    onSelectUserMediaItemListener.onItemSelected(recentMediaListAdapter.getItem(position));
                }
        );
        userMediaRecyclerView.addItemDecoration(new SpacingDecoration(
                getActivity(), R.dimen.item_spacing_decoration, GRID_SPAN_COUNT, false
        ));

        userMediaRecyclerView.setAdapter(recentMediaListAdapter);
    }

    protected void initUserListMediaPresenter(Bundle extras) {
        long userId = extras != null ? extras.getLong("UserID") : 0;
        userMediaListPresenter = new UserMediaListPresenter(this, userId);
    }

    protected void afterInitViews() {
        getPresenter().onScrollUserMediaGridView();
    }

    @Override
    public UserMediaListPresenter getPresenter() {
        return userMediaListPresenter;
    }

    public void updateRecentMediaAdapter(List<RecentMedia> recentMediaList) {
        recentMediaListAdapter.addItems(recentMediaList);
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
        recentMediaListAdapter.showProgressBar();
    }

    public void hideRecentMediaProgressBar() {
        recentMediaListAdapter.hideProgressBar();
    }
}
