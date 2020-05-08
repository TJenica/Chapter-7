package com.bytedance.videoplayer;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;


public class MainActivity extends AppCompatActivity {

    private CustomizeVideoview videoView;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.video_view);
        mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);

//        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/" + R.raw.workaholic);
//        videoView.setVideoURI(uri);
        Intent intent = getIntent();
        Uri realUri;
        Uri data = intent.getData();
        if(data != null) {
            realUri = data;
        } else {
            realUri = Uri.parse("android.resource://" + getPackageName() + "/raw/" + R.raw.workaholic);
        }

        videoView.setVideoURI(realUri);
        videoView.start();

    }

    @Override

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}
