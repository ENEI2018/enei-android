package com.enei.eneimobile.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enei.eneimobile.R;
import com.enei.eneimobile.utils.Constants;
import com.enei.eneimobile.utils.DialogHelper;

public class Day2Fragment extends ScheduleDayFragment {
    private static final String TAG = "Day1Fragment";
    private static final String TITLE = "24/Março";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            view.findViewById(R.id.speaker_tanenbaum).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_andrebatista).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_andresilva).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_danielteixeira).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_debate).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_filipecarvalho).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ivosilva).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_luispauloreis).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_networking).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_renatorodrigues).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ruicosta).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ws1).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ws2).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ws3).setOnClickListener(Constants.speakerListener);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

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
