package com.raulbrumar.externalactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText urlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditText = findViewById(R.id.editText);
    }

    public void openMap(View view)
    {
        Uri locationSearch = Uri.parse("geo:0,0?q=Oulun+Ammattikorkeakoulu(OAMK),+Kotkantie 1,+Oulu");
        Intent intent = new Intent(Intent.ACTION_VIEW, locationSearch);

        startActivity(intent);
    }

    public void createCall(View view)
    {
        Uri number = Uri.parse("tel:+358206110200");
        Intent intent = new Intent(Intent.ACTION_DIAL, number);

        startActivity(intent);
    }

    public void goToWebsite(View view)
    {
        try {
            Uri page = Uri.parse(urlEditText.getText().toString());
            Intent intent = new Intent(Intent.ACTION_VIEW, page);

            startActivity(intent);
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Please input a valid URL.", Toast.LENGTH_SHORT).show();
        }
    }
}
