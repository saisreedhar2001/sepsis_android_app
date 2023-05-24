package com.dodo.sepsis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class browser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        WebView browser = (WebView) findViewById(R.id.webview);

        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        ProgressDialog progressDialog = ProgressDialog.show(browser.this,"Loading","Please Wait",true);
        progressDialog.setCancelable(false);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);
         browser.setWebViewClient(new WebViewClient(){
             @Override
             public boolean shouldOverrideUrlLoading(WebView view, String url) {
                 progressDialog.show();
                 view.loadUrl(url);
                 return true;
             }

             @Override
             public void onPageFinished(WebView view, String url) {
                 progressDialog.dismiss();

             }
         });

        browser.loadUrl("https://saisreedhar2001-finalyear-prediction-q7l6vi.streamlit.app");
    }
}