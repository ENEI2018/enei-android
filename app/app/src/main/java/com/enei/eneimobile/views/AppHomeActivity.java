package com.enei.eneimobile.views;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.enei.eneimobile.R;
import com.enei.eneimobile.utils.Constants;

import java.lang.reflect.Field;

import static com.enei.eneimobile.views.GameActivity.APP_URL_PREFIX;
import static com.enei.eneimobile.views.GameActivity.EXTRA_KEY;

public class AppHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String readUrl = getIntent().getDataString();
        if (readUrl != null) {
            readUrl = readUrl.substring(APP_URL_PREFIX.length());
            for(GameActivity.Location gameLoc : GameActivity.newLocations) {
                if(gameLoc.hash.equals(readUrl)) {
                    Intent intent = new Intent(AppHomeActivity.this, GameActivity.class);
                    intent.putExtra(EXTRA_KEY, readUrl);
                    startActivity(intent);
                }
            }

            for(GameActivity.Location gameLoc : PeddyPaperActivity.newLocations) {
                if(gameLoc.hash.equals(readUrl)) {
                    Intent intent = new Intent(AppHomeActivity.this, PeddyPaperActivity.class);
                    intent.putExtra(EXTRA_KEY, readUrl);
                    startActivity(intent);
                }
            }
        }

        Constants.appContext = this;

        Button websiteButton = findViewById(R.id.button_website);
        Button programButton = findViewById(R.id.button_program);
        Button gameButton = findViewById(R.id.button_game);
        Button peddyPaperButton = findViewById(R.id.button_peddypaper);

        Typeface customFont = Typeface.createFromAsset(getAssets(), Constants.FONT_PATH);
        websiteButton.setTypeface(customFont);
        programButton.setTypeface(customFont);
        gameButton.setTypeface(customFont);
        peddyPaperButton.setTypeface(customFont);
        websiteButton.setBackgroundColor(Constants.BACKGROUND_PURPLE);
        programButton.setBackgroundColor(Constants.BACKGROUND_PURPLE);
        gameButton.setBackgroundColor(Constants.BACKGROUND_PURPLE);
        peddyPaperButton.setBackgroundColor(Constants.BACKGROUND_PURPLE);

        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open website in browser
                Intent browserIntent = new Intent(AppHomeActivity.this, WebViewActivity.class);
                startActivity(browserIntent);
            }
        });

        programButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open program activity
                Intent myIntent =
                        new Intent(AppHomeActivity.this, ScheduleActivity.class);
                AppHomeActivity.this.startActivity(myIntent);
            }
        });

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open program activity
                Intent myIntent =
                        new Intent(AppHomeActivity.this, GameActivity.class);
                AppHomeActivity.this.startActivity(myIntent);
            }
        });

        peddyPaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open program activity
                Intent myIntent =
                        new Intent(AppHomeActivity.this, PeddyPaperActivity.class);
                AppHomeActivity.this.startActivity(myIntent);
            }
        });

        try {
            overrideDefaultFont();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void overrideDefaultFont() throws NoSuchFieldException, IllegalAccessException {
        Typeface customFont = Typeface.createFromAsset(getAssets(), Constants.FONT_PATH);

        final Field defaultFontTypefaceField = Typeface.class.getDeclaredField("SERIF");
        defaultFontTypefaceField.setAccessible(true);
        defaultFontTypefaceField.set(null, customFont);
    }

}
