package com.dev.your_mirror.anonymousinstagrammer.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.dev.your_mirror.anonymousinstagrammer.R;
import com.dev.your_mirror.anonymousinstagrammer.presenter.UserSearchPresenter;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;
import com.dev.your_mirror.anonymousinstagrammer.view.activities.RecentMediaActivity;
import com.dev.your_mirror.anonymousinstagrammer.view.adapters.UserListAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserSearchFragment extends BaseFragment {
    UserSearchPresenter userSearchPresenter;
    EditText searchUserEdit;
    UserListAdapter searchUserListViewAdapter;
    ListView searchUserListView;
    ImageButton searchUserClearButton;
    ProgressBar searchUserProgressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_user_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews();
        initPresenter();
    }

    @Override
    public UserSearchPresenter getPresenter() {
        return userSearchPresenter;
    }

    protected void initViews() {
        // init R.id.search_user_edit
        searchUserEdit = (EditText) getActivity().findViewById(R.id.search_user_edit);
        searchUserEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                getPresenter().onEditSearchUser();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        // init R.id.search_user_list
        searchUserListView = (ListView) getActivity().findViewById(R.id.search_user_list);
        searchUserListViewAdapter = new UserListAdapter(getContext(), new ArrayList<User>());
        searchUserListView.setAdapter(searchUserListViewAdapter);

        searchUserListView.setOnItemClickListener((adapterView, view, i, l) -> {
            getPresenter().onSearchUserItemClick(i);
        });
        // hide keyboard on touch outside
        searchUserListView.setOnTouchListener((view, event) -> {
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(searchUserEdit.getWindowToken(), 0);

                    return false;
                }
        );
        // init R.id.search_user_clear_button
        searchUserClearButton = (ImageButton) getActivity().findViewById(R.id.search_user_clear_button);
        searchUserClearButton.setOnClickListener(view -> {
            getPresenter().onEmptySearchUser();
        });
        // R.id.spinner_progress_bar
        searchUserProgressBar = (ProgressBar) getActivity().findViewById(R.id.spinner_progress_bar);
    }

    private void initPresenter() {
        userSearchPresenter = new UserSearchPresenter(this);
    }

    public void showError(String title, String message) {
        new AlertDialog.Builder(getContext())
            .setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(R.string.ok, (dialogInterface, i) -> {})
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show();
    }

    public String getUserName() {
        return searchUserEdit.getText().toString();
    }

    public void updateSearchUserAdapter(List<User> users) {
        searchUserListViewAdapter.clear();
        searchUserListViewAdapter.addAll(users);
    }

    public void clearSearchUserAdapter() {
        searchUserListViewAdapter.clear();
        searchUserListViewAdapter.notifyDataSetChanged();
    }

    public void updateSearchUserClearButton() {
        if (TextUtils.isEmpty(searchUserEdit.getText())) {
            searchUserClearButton.setVisibility(View.INVISIBLE);
        }
        else {
            searchUserClearButton.setVisibility(View.VISIBLE);
        }
    }

    public void clearSearchUserEditText() {
        searchUserEdit.setText("");
    }

    public void showSearchUserProgressBar() {
        searchUserProgressBar.setVisibility(View.VISIBLE);
    }

    public void hideSearchUserProgressBar() {
        searchUserProgressBar.setVisibility(View.GONE);
    }

    public void goToUserMedia(int position) {
        User user = searchUserListViewAdapter.getItem(position);
        Intent userMediaIntent = new Intent(getActivity(), RecentMediaActivity.class);
        userMediaIntent.putExtra("UserID", user.getId());
        getActivity().startActivity(userMediaIntent);
    }
}
