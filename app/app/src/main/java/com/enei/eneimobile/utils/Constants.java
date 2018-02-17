package com.enei.eneimobile.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.enei.eneimobile.R;

import java.util.HashMap;
import java.util.Map;

public abstract class Constants {
    public static Context appContext = null;

    public static final String ENEI_WEBSITE = "https://enei.pt";
    public static final String FONT_PATH = "Montserrat-Regular.ttf";

    public static final int BACKGROUND_PURPLE = Color.rgb(90, 0, 255);
    public static final int BACKGROUND_DARK_BLUE = Color.rgb(0, 0, 95);

    public static final Map<Integer, String> speakerLinks = new HashMap<Integer, String>();
    static {
        speakerLinks.put(R.id.speaker_tanenbaum, ENEI_WEBSITE + "/speakers/12");
        speakerLinks.put(R.id.speaker_andresilva, ENEI_WEBSITE + "/speakers/0");
        speakerLinks.put(R.id.speaker_ruicosta, ENEI_WEBSITE + "/speakers/11");
        speakerLinks.put(R.id.speaker_wolfgang, ENEI_WEBSITE + "/speakers/14");
        speakerLinks.put(R.id.speaker_espinheira, ENEI_WEBSITE + "/speakers/13");
        speakerLinks.put(R.id.speaker_joaoazevedo, ENEI_WEBSITE + "/speakers/9");
        speakerLinks.put(R.id.speaker_josepedrosilva, ENEI_WEBSITE + "/speakers/10");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/1");
        speakerLinks.put(R.id.speaker_ferrolho, ENEI_WEBSITE + "/speakers/3");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/1");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/1");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/1");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/1");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/1");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/1");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/1");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/1");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/1");
        //view.findViewById(R.id.speaker_tanenbaum).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_andrebatista).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_danielteixeira).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_debate).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_filipecarvalho).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ivosilva).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_luispauloreis).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_networking).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_renatorodrigues).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws1).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws2).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws3).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_paulopatricio).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws4).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws5).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_andrecruz).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws6).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_alexey).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_jobvandervoort).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_guilhermeduarte).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_karaoke1).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws7).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws8).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_slot1).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_slot2).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_karaoke2).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_nelsonpinho).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws9).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_pedrocaramez).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_mariocarneiro).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ruiguedes).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_leonelmorgado).setOnClickListener(Constants.speakerListener);
    }

    public static final View.OnClickListener speakerListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(appContext == null) {
                return;
            }

            if(speakerLinks.containsKey(view.getId())) {
                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse(speakerLinks.get(view.getId())));
                appContext.startActivity(browserIntent);
            } else {
                DialogHelper.showOkDialog(appContext, "Link indisponível.");
            }
        }
    };
}
