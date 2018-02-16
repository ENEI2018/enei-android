package com.enei.eneiapp.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enei.eneiapp.R;

public class Day2Fragment extends ScheduleDayFragment {
    private static final String TAG = "Day1Fragment";
    private static final String TITLE = "24/Março";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.day2fragment, container, false);
        return v;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
