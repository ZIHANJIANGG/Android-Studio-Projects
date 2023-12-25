package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://cn.bing.com/?FORM=Z9FD1");
        WebSettings webSettings = webview.getSettings();



    }
    @Override
    public void onBackPressed() {
        if (webview.canGoBack()){
            webview.goBack();
        }
        else {
        super.onBackPressed();

    }
}}