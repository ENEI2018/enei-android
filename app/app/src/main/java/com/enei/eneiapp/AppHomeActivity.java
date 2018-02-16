package com.enei.eneiapp;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class AppHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Montserrat-Regular.ttf");
        button1.setTypeface(custom_font);
        button2.setTypeface(custom_font);
        button1.setBackgroundColor(Color.rgb(90, 0, 255));
        button2.setBackgroundColor(Color.rgb(90, 0, 255));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://enei.pt"));
                startActivity(browserIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent =
                        new Intent(AppHomeActivity.this, ScheduleActivity.class);
                AppHomeActivity.this.startActivity(myIntent);
            }
        });
    }

}
