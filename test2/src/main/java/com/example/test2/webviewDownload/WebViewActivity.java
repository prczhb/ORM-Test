package com.example.test2.webviewDownload;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.test2.R;

public class WebViewActivity extends AppCompatActivity {


    private WebView wv_down;
    private DownloadManager downloadManager;
    private String url;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_down);
        initView();
        //启用支持javascript
        WebSettings settings = wv_down.getSettings();
        settings.setJavaScriptEnabled(true);

        url = "http://h5.m.jd.com/active/download/download.html";
        wv_down.loadUrl(url);
        wv_down.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                startDownload(url);

            }
        });

    }

    private void startDownload(String url) {
        downloadManager = (DownloadManager) this.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(
                Uri.parse(url));
        request.setMimeType("application/vnd.android.package-archive");
        request.setVisibleInDownloadsUi(true);
        request.setDestinationInExternalFilesDir(this,
                Environment.DIRECTORY_DOWNLOADS, "fileName");

        //添加下面这段代码
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        long enqueue = downloadManager.enqueue(request);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void initView() {
        wv_down = (WebView) findViewById(R.id.wv_down);
    }
}
