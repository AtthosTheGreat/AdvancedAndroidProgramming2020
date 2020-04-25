package com.raulbrumar.complexuiprogramatically;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String COUNTRIES[] = new String[] {
        "Afganistan", "Albania", "Algeria", "American Samoa", "Andorra",
                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
                "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan"
    };

    Button addButton;
    Button editButton;
    Button removeButton;
    EditText editText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout completeLayout = new LinearLayout(this);
        completeLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout buttonsLayout = new LinearLayout(this);
        buttonsLayout.setGravity(Gravity.CENTER);

        addButton = new Button(this);
        addButton.setText("Add");
        buttonsLayout.addView(addButton);

        editButton = new Button(this);
        editButton.setText("Edit");
        buttonsLayout.addView(editButton);

        removeButton = new Button(this);
        removeButton.setText("Remove");
        buttonsLayout.addView(removeButton);

        completeLayout.addView(buttonsLayout);

        editText = new EditText(this);
        completeLayout.addView(editText);

        listView = new ListView(this);
        completeLayout.addView(listView);

        setContentView(completeLayout);
    }
}
