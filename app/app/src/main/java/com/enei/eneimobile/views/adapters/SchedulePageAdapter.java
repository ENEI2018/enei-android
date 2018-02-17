package com.enei.eneimobile.views.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.enei.eneimobile.views.fragments.ScheduleDayFragment;

import java.util.ArrayList;
import java.util.List;

public class SchedulePageAdapter extends FragmentPagerAdapter {

    private final List<ScheduleDayFragment> mFragmentList = new ArrayList<>();

    public void addFragment(ScheduleDayFragment fragment) {
        mFragmentList.add(fragment);
    }

    public SchedulePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
