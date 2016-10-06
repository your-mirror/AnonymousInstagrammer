package com.dev.your_mirror.anonymousinstagrammer.view.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dev.your_mirror.anonymousinstagrammer.view.fragments.UserSearchFragment;
import com.dev.your_mirror.anonymousinstagrammer.view.fragments.UsersParallaxFragment;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    final int FRAGMENT_COUNT = 2;
    private Context context;

    public TabFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new UsersParallaxFragment();
            case 1:
                return new UserSearchFragment();
            default:
                throw new NullPointerException();
        }
    }
}