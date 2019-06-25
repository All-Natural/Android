package com.dongyiying.work_4;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.dongyiying.work_4.app.R;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    private VideoView videoView;
    private static final int FILE_SELECT_CODE = 1;
    private static final String TAG = "VideoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView = findViewById(R.id.vv_video);
        Button play = findViewById(R.id.bt_play);
        Button pause = findViewById(R.id.bt_pause);
        Button replay = findViewById(R.id.bt_replay);
        Button choice = findViewById(R.id.bt_choice);
        choice.setOnClickListener(this);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(VideoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(VideoActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);//判断你是否授权
        }
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_play:
                if (!videoView.isPlaying()) {
                    videoView.start();
                }
                break;
            case R.id.bt_pause:
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
                break;
            case R.id.bt_replay:
                if (videoView.isPlaying()) {
                    videoView.resume();
                }
                break;
            case R.id.bt_choice://选择文件
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 1);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            videoView.setVideoURI(uri);
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (requestCode == FILE_SELECT_CODE) {
            Uri uri = data.getData();
            Log.i(TAG, "------->" + uri.getPath());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

