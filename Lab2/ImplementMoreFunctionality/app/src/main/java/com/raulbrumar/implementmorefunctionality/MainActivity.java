package com.raulbrumar.implementmorefunctionality;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    String COUNTRIES[] = new String[] {
            "Afganistan", "Albania", "Algeria", "American Samoa", "Andorra",
            "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
            "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan"
    };

    ArrayList<String> countries = new ArrayList<String>();

    Button addButton;
    Button editButton;
    Button removeButton;
    EditText editText;
    ListView listView;

    ArrayAdapter<String> adapter;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        Collections.addAll(countries, COUNTRIES);

        LinearLayout completeLayout = new LinearLayout(this);
        completeLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout buttonsLayout = new LinearLayout(this);
        buttonsLayout.setGravity(Gravity.CENTER);

        addButton = new Button(this);
        addButton.setText("Add");
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().equals(""))
                {
                    Toast.makeText(context, "You need to input a country.", Toast.LENGTH_SHORT).show();
                    return;
                }

                countries.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        buttonsLayout.addView(addButton);

        editButton = new Button(this);
        editButton.setText("Edit");
        buttonsLayout.addView(editButton);

        removeButton = new Button(this);
        removeButton.setText("Remove");
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().equals(""))
                {
                    Toast.makeText(context, "You need to input a country.", Toast.LENGTH_SHORT).show();
                    return;
                }

                countries.remove(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        buttonsLayout.addView(removeButton);

        completeLayout.addView(buttonsLayout);

        editText = new EditText(this);
        completeLayout.addView(editText);

        listView = new ListView(this);
        completeLayout.addView(listView);

        setContentView(completeLayout);



        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        listView.setAdapter(adapter);
    }
}
