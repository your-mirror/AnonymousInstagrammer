package com.dev.your_mirror.anonymousinstagrammer.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.dev.your_mirror.anonymousinstagrammer.R;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.RecentMedia;
import com.dev.your_mirror.anonymousinstagrammer.view.fragments.UserMediaFragment;
import com.dev.your_mirror.anonymousinstagrammer.view.fragments.UserMediaListFragment;

public class RecentMediaActivity extends AppCompatActivity implements UserMediaListFragment.OnUserMediaItemSelectedListener {
    private Fragment userMediaListFragment;
    private Fragment userMediaFragment;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_media);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentManager = getSupportFragmentManager();
        userMediaListFragment = new UserMediaListFragment();

        fragmentManager.beginTransaction()
            .add(R.id.user_media_fragment, userMediaListFragment, UserMediaListFragment.TAG)
            .commit();
    }

    @Override
    public void onItemSelected(RecentMedia recentMedia) {
        userMediaFragment = new UserMediaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(UserMediaFragment.RECENT_MEDIA, recentMedia);
        userMediaFragment.setArguments(bundle);
        fragmentManager.beginTransaction().
            replace(R.id.user_media_fragment, userMediaFragment, UserMediaFragment.TAG)
            .addToBackStack(null)
            .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
