package com.raulbrumar.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity
{
    TextView timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timeTextView = findViewById(R.id.time);

        Intent originalIntent = getIntent();
        int time = originalIntent.getIntExtra("seconds", 1) * 1000;

        new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                timeTextView.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timeTextView.setText("done!");

                finish();
            }
        }.start();
    }
}
