package com.enei.eneimobile.views;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.enei.eneimobile.R;
import com.enei.eneimobile.utils.Constants;
import com.google.zxing.Result;

import java.lang.reflect.Field;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static com.enei.eneimobile.views.GameActivity.APP_URL_PREFIX;
import static com.enei.eneimobile.views.GameActivity.EXTRA_KEY;

public class AppHomeActivity extends AppCompatActivity {
    public static final int PERMISSION_REQUEST_CAMERA = 1;
    public static final int CAMERA_CODE = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String readUrl = getIntent().getDataString();
        if (readUrl != null) {
            checkEneiUrl(readUrl);
        }

        Constants.appContext = this;

        Button websiteButton = findViewById(R.id.button_website);
        Button programButton = findViewById(R.id.button_program);
        Button gameButton = findViewById(R.id.button_game);
        Button peddyPaperButton = findViewById(R.id.button_peddypaper);
        ImageButton qrCodeButton = findViewById(R.id.buttonReadQr);

        Typeface customFont = Typeface.createFromAsset(getAssets(), Constants.FONT_PATH);
        websiteButton.setTypeface(customFont);
        programButton.setTypeface(customFont);
        gameButton.setTypeface(customFont);
        peddyPaperButton.setTypeface(customFont);

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
                Intent myIntent =
                        new Intent(AppHomeActivity.this, GameActivity.class);
                AppHomeActivity.this.startActivity(myIntent);
            }
        });

        peddyPaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent =
                        new Intent(AppHomeActivity.this, PeddyPaperActivity.class);
                AppHomeActivity.this.startActivity(myIntent);
            }
        });

        qrCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!haveCameraPermission()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
                    }
                } else {
                    startCamera();
                }

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

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // This is because the dialog was cancelled when we recreated the activity.
        if (permissions.length == 0 || grantResults.length == 0)
            return;

        switch (requestCode) {
            case PERMISSION_REQUEST_CAMERA: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startCamera();
                } else {
                    finish();
                }
            }
            break;
        }
    }

    private void startCamera() {
        Intent myIntent =
                new Intent(AppHomeActivity.this, CameraActivity.class);
        startActivityForResult(myIntent, CAMERA_CODE);
    }

    private void overrideDefaultFont() throws NoSuchFieldException, IllegalAccessException {
        Typeface customFont = Typeface.createFromAsset(getAssets(), Constants.FONT_PATH);

        final Field defaultFontTypefaceField = Typeface.class.getDeclaredField("SERIF");
        defaultFontTypefaceField.setAccessible(true);
        defaultFontTypefaceField.set(null, customFont);
    }

    private boolean haveCameraPermission() {
        if (Build.VERSION.SDK_INT < 23)
            return true;
        return checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_CODE) {
            if (resultCode == RESULT_OK) {
                String returnedResult = data.getData().toString();
                checkEneiUrl(returnedResult);
            }
        }
    }

    private void checkEneiUrl(String readUrl) {
        readUrl = readUrl.substring(APP_URL_PREFIX.length());
        for (GameActivity.Location gameLoc : GameActivity.newLocations) {
            if (gameLoc.hash.equals(readUrl)) {
                Intent intent = new Intent(AppHomeActivity.this, GameActivity.class);
                intent.putExtra(EXTRA_KEY, readUrl);
                startActivity(intent);
            }
        }

        for (GameActivity.Location gameLoc : PeddyPaperActivity.newLocations) {
            if (gameLoc.hash.equals(readUrl)) {
                Intent intent = new Intent(AppHomeActivity.this, PeddyPaperActivity.class);
                intent.putExtra(EXTRA_KEY, readUrl);
                startActivity(intent);
            }
        }
    }
}
