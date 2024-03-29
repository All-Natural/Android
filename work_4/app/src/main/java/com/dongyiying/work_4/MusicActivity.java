package com.dongyiying.work_4;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dongyiying.work_4.app.R;

import java.io.File;
import java.io.IOException;

public class MusicActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Button play=findViewById(R.id.bt_music_play);
        Button pause=findViewById(R.id.bt_music_pause);
        Button stop=findViewById(R.id.bt_music_stop);
        play.setOnClickListener((View.OnClickListener) this);
        pause.setOnClickListener((View.OnClickListener) this);
        stop.setOnClickListener((View.OnClickListener) this);
        if(ContextCompat.checkSelfPermission(MusicActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MusicActivity.this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        }
        else{
            initMediaPlayer();
        }
    }private void initMediaPlayer(){
        try{
            File file=new File(Environment.getExternalStorageDirectory(),"music.mp3");
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String[]permissions,int[] grantResults){
        switch (requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                    initMediaPlayer();
                }else {
                    Toast.makeText(this,"拒绝权限将无法使用程序",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_play:
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }break;
            case R.id.bt_pause:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }break;
            case R.id.stop:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.reset();
                    initMediaPlayer();
                }break;
            default:
                break;
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}


