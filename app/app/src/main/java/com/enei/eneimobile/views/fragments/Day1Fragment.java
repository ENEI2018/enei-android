package com.enei.eneimobile.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enei.eneimobile.R;
import com.enei.eneimobile.utils.Constants;

public class Day1Fragment extends ScheduleDayFragment {
    private static final String TAG = "Day1Fragment";
    private static final String TITLE = "23/Março";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            view.findViewById(R.id.speaker_checkin).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_opening).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_welcome).setOnClickListener(Constants.speakerListener);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.day1fragment, container, false);
        return v;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
