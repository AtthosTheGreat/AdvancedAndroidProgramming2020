package com.raulbrumar.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText timeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeEditText = findViewById(R.id.time);
    }

    public void startTimer(View view)
    {
        try {
            int time = Integer.parseInt(timeEditText.getText().toString());

            Intent intent = new Intent(this, TimerActivity.class);
            intent.putExtra("seconds", time);
            startActivity(intent);
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Please input the time in seconds as a number.", Toast.LENGTH_SHORT).show();
        }
    }
}
