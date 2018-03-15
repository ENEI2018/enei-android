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
        speakerLinks.put(R.id.speaker_luispauloreis, ENEI_WEBSITE + "/speakers/19");
        speakerLinks.put(R.id.speaker_ivosilva, ENEI_WEBSITE + "/speakers/8");
        speakerLinks.put(R.id.speaker_ws1, ENEI_WEBSITE + "/talks/3");
        speakerLinks.put(R.id.speaker_renatorodrigues, ENEI_WEBSITE + "/talks/4");
        speakerLinks.put(R.id.speaker_andrebatista, ENEI_WEBSITE + "/talks/5");
        speakerLinks.put(R.id.speaker_danielteixeira, ENEI_WEBSITE + "/speakers/20");
        speakerLinks.put(R.id.speaker_filipecarvalho, ENEI_WEBSITE + "/talks/6");
        speakerLinks.put(R.id.speaker_networking, ENEI_WEBSITE + "/talks/0");
        speakerLinks.put(R.id.speaker_alexey, ENEI_WEBSITE + "/speakers/15");
        speakerLinks.put(R.id.speaker_jobvandervoort, ENEI_WEBSITE + "/speakers/16");
        speakerLinks.put(R.id.speaker_andrecruz, ENEI_WEBSITE + "/talks/10");
        speakerLinks.put(R.id.speaker_ws6, ENEI_WEBSITE + "/talks/11");
        speakerLinks.put(R.id.speaker_slot1, ENEI_WEBSITE + "/speakers/18");
        speakerLinks.put(R.id.speaker_nelsonpinho, ENEI_WEBSITE + "/speakers/2");
        speakerLinks.put(R.id.speaker_leonelmorgado, ENEI_WEBSITE + "/speakers/17");
        speakerLinks.put(R.id.speaker_ws9, ENEI_WEBSITE + "/speakers/12");
        speakerLinks.put(R.id.speaker_mariocarneiro, ENEI_WEBSITE + "/talks/13");
        speakerLinks.put(R.id.speaker_ws4, ENEI_WEBSITE + "/talks/8");
        speakerLinks.put(R.id.speaker_paulopatricio, ENEI_WEBSITE + "/talks/7");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/");
        //view.findViewById(R.id.speaker_debate).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws2).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws3).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws5).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_karaoke1).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws7).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws8).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_slot2).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_karaoke2).setOnClickListener(Constants.speakerListener)
        //view.findViewById(R.id.speaker_pedrocaramez).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ruiguedes).setOnClickListener(Constants.speakerListener);
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
