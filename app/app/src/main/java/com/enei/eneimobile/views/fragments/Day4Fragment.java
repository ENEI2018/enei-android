package com.enei.eneimobile.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enei.eneimobile.R;
import com.enei.eneimobile.utils.Constants;

public class Day4Fragment extends ScheduleDayFragment {
    private static final String TAG = "Day1Fragment";
    private static final String TITLE = "26/Março";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            view.findViewById(R.id.speaker_nelsonpinho).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ws9).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_pedrocaramez).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_mariocarneiro).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ruiguedes).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_leonelmorgado).setOnClickListener(Constants.speakerListener);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.day4fragment, container, false);
        return v;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
