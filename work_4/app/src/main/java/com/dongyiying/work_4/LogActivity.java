package com.dongyiying.work_4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.dongyiying.work_4.app.R;


public class LogActivity extends AppCompatActivity {
    private EditText accountEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private SharedPreferences defaultdataSharedPreferences;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        defaultdataSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        accountEditText = findViewById(R.id.edit_1);
        passwordEditText = findViewById(R.id.edit_2);
        passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        loginButton = findViewById(R.id.button_1);
        rememberPass = findViewById(R.id.save_data);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        boolean isRemember = defaultdataSharedPreferences.getBoolean("remember_password",false);
        if (isRemember) {
            String account = defaultdataSharedPreferences.getString("account"," ");
            String password = defaultdataSharedPreferences.getString("password"," ");
            accountEditText.setText(account);
            passwordEditText.setText(password);
            rememberPass.setChecked(true);
        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogActivity.this, MainActivity.class);
                startActivity(intent);
                String account = accountEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                editor = defaultdataSharedPreferences.edit();
                if (rememberPass.isChecked()) {
                    editor.putBoolean("remember_password",true);
                    editor.putString("account",account);
                    editor.putString("password",password);
                    editor.apply();
                }
            }
        });
    }

    }


