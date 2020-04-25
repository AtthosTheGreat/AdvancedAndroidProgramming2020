package com.raulbrumar.menus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    ConstraintLayout layout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main_layout);
        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.red:
                layout.setBackgroundColor(Color.RED);
                textView.setText("Red");
                return true;
            case R.id.green:
                layout.setBackgroundColor(Color.GREEN);
                textView.setText("Green");
                return true;
            case R.id.blue:
                layout.setBackgroundColor(Color.BLUE);
                textView.setText("Blue");
                return true;
            case R.id.yellow:
                layout.setBackgroundColor(Color.YELLOW);
                textView.setText("Yellow");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
