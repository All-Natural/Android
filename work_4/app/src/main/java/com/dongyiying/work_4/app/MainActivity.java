package com.dongyiying.work_4.app;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import com.dongyiying.work_4.MusicActivity;
import com.dongyiying.work_4.VideoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_1=findViewById(R.id.bt_jump_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MusicActivity.class);
                startActivity(intent);
            }
        });
        Button button_3=findViewById(R.id.bt_jump_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
    }
}
