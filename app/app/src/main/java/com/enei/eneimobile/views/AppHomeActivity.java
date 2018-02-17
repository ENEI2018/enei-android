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

public class AppHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button websiteButton = findViewById(R.id.button_website);
        Button programButton = findViewById(R.id.button_program);

        Typeface customFont = Typeface.createFromAsset(getAssets(), Constants.FONT_PATH);
        websiteButton.setTypeface(customFont);
        programButton.setTypeface(customFont);
        websiteButton.setBackgroundColor(Constants.BACKGROUND_PURPLE);
        programButton.setBackgroundColor(Constants.BACKGROUND_PURPLE);

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
