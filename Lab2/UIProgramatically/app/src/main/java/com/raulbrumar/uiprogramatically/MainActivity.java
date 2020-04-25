package com.raulbrumar.uiprogramatically;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int noOfClicks = 0;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        button = new Button(this);
        button.setText("Hello, I'm the button! Click me!");

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                noOfClicks++;
                button.setText("Button clicked " + noOfClicks + " times.");
            }
        });

        setContentView(button);
    }
}
