package com.enei.eneimobile.views;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.enei.eneimobile.R;


public class mWebViewClient extends WebViewClient {
    private Activity activity;
    private ProgressBar progressBar;
    private ImageView loadingFilter;

    public mWebViewClient(Activity activity) {
        this.activity = activity;
        this.progressBar = activity.findViewById(R.id.loadingProgressBar);
        progressBar.setVisibility(View.VISIBLE);
        this.loadingFilter = activity.findViewById(R.id.loadingFilter);;
        loadingFilter.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String url = request.getUrl().toString();
            if(url.startsWith("https://enei.pt")) {
                view.loadUrl(url);
            } else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                view.getContext().startActivity(browserIntent);
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
        Animation fade_out = AnimationUtils.loadAnimation(activity, R.anim.fade_out);
        progressBar.startAnimation(fade_out);
        loadingFilter.setVisibility(View.GONE);
        loadingFilter.startAnimation(fade_out);
    }
}