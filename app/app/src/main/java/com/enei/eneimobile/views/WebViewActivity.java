package com.enei.eneimobile.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.enei.eneimobile.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        myWebView = findViewById(R.id.mainwebview);

        // Enable Javascript
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Enable Cache
        webSettings.setAppCacheEnabled(true);

        myWebView.setWebViewClient(new mWebViewClient(this));

        myWebView.loadUrl("https://enei.pt/");
    }

    // Prevent the back-button from closing the app
    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
