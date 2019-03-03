package com.sse.gosockeyes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientHandler extends WebViewClient {
    private Context context;

    public WebViewClientHandler(Context context) {
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(url.equals("survey://survey_activity")){
            Intent i = new Intent(context, SurveyActivity.class);
            context.startActivity(i);
            return true;
        } else {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url ));
            context.startActivity(browserIntent);
            return true;
        }
    }
}
