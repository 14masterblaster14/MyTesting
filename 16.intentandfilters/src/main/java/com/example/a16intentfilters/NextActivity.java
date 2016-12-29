package com.example.a16intentfilters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent responsibleIntent = getIntent();
        final WebView webview = (WebView) findViewById(R.id.webView);
        webview.loadUrl(responsibleIntent.getData().toString());

    }
}
