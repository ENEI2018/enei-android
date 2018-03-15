package com.enei.eneimobile.views;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.enei.eneimobile.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class CameraActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mScannerView = new ZXingScannerView(CameraActivity.this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(CameraActivity.this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mScannerView != null) {
            mScannerView.stopCamera();
        }
    }

    @Override
    public void handleResult(Result result) {
        Intent data = new Intent();
        data.setData(Uri.parse(result.getText()));
        setResult(RESULT_OK, data);
        finish();
    }
}
