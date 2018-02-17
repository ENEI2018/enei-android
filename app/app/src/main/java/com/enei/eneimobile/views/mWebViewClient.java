package com.enei.eneimobile.views;

import android.os.Build;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class mWebViewClient extends WebViewClient {
    private ProgressBar progressBar;

    public mWebViewClient(ProgressBar progressBar) {
        this.progressBar = progressBar;
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String url = request.getUrl().toString();
            if(url.startsWith("https://enei.pt")) {
                view.loadUrl(url);
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        // TODO Auto-generated method stub
        super.onPageFinished(view, url);
        progressBar.setVisibility(View.GONE);
    }
}