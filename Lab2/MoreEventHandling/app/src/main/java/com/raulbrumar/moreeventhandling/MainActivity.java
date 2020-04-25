package com.raulbrumar.moreeventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText nameEditText;
    private Button englishButton;
    private Button sverigeButton;
    private Button suomeksiButton;
    private Button surpriseButton;
    private TextView greetingTextView;

    private int selectedLanguage = 0;
    // 0 = english
    // 1 = sverige
    // 2 = suomeksi
    // 3 = surprise

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.editText);
        englishButton = findViewById(R.id.englishButton);
        sverigeButton = findViewById(R.id.sverigeButton);
        suomeksiButton = findViewById(R.id.suomeksiButton);
        surpriseButton = findViewById(R.id.surpriseButton);
        greetingTextView = findViewById(R.id.textView);

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedLanguage = 0;
                greetingTextView.setText("Hello " + nameEditText.getText().toString());
            }
        });

        sverigeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedLanguage = 1;
                greetingTextView.setText("Hejjsan " + nameEditText.getText().toString());
            }
        });
        suomeksiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedLanguage = 2;
                greetingTextView.setText("Terve " + nameEditText.getText().toString());
            }
        });
        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedLanguage = 3;
                greetingTextView.setText("Hola " + nameEditText.getText().toString());
            }
        });

        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                switch (selectedLanguage)
                {

                    case 0:
                        greetingTextView.setText("Hello " + charSequence);
                        break;
                    case 1:
                        greetingTextView.setText("Hejjsan " + charSequence);
                        break;
                    case 2:
                        greetingTextView.setText("Terve " + charSequence);
                        break;
                    case 3:
                        greetingTextView.setText("Hola " + charSequence);
                        break;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
