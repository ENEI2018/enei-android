package com.enei.eneimobile.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enei.eneimobile.R;
import com.enei.eneimobile.utils.Constants;

public class Day3Fragment extends ScheduleDayFragment {
    private static final String TAG = "Day1Fragment";
    private static final String TITLE = "25/Março";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            view.findViewById(R.id.speaker_wolfgang).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_paulopatricio).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ws4).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ws5).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_espinheira).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_joaoazevedo).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_josepedrosilva).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_joaoleal).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ferrolho).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_andrecruz).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ws6).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_alexey).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_jobvandervoort).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_guilhermeduarte).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_karaoke1).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ws7).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_ws8).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_slot1).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_slot2).setOnClickListener(Constants.speakerListener);
            view.findViewById(R.id.speaker_karaoke2).setOnClickListener(Constants.speakerListener);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.day3fragment, container, false);
        return v;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
