package com.android.liuyifan.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class SmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        SMSSDK.initSDK(this,"19c575bf2a028","98d2691fa2425badd3c1f697274dd2ca");
        RegisterPage registerPage = new RegisterPage();
    }
}
