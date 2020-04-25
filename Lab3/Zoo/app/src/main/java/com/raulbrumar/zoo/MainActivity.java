package com.raulbrumar.zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView topLeft;
    ImageView topRight;
    ImageView bottomLeft;
    ImageView bottomRight;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topLeft = findViewById(R.id.topLeft);
        topRight = findViewById(R.id.topRight);
        bottomLeft = findViewById(R.id.bottomLeft);
        bottomRight = findViewById(R.id.bottomRight);

        mediaPlayer = MediaPlayer.create(this, R.raw.bear);

        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playBear();
            }
        });
        topRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playWolf();
            }
        });
        bottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playElephant();
            }
        });
        bottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playLamb();
            }
        });
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
            case R.id.mammals:
                topLeft.setImageResource(R.drawable.bear);
                topRight.setImageResource(R.drawable.wolf);
                bottomLeft.setImageResource(R.drawable.elephant);
                bottomRight.setImageResource(R.drawable.lamb);

                topLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playBear();
                    }
                });
                topRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playWolf();
                    }
                });
                bottomLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playElephant();
                    }
                });
                bottomRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playLamb();
                    }
                });

                return true;
            case R.id.birds:
                topLeft.setImageResource(R.drawable.huuhkaja);
                topRight.setImageResource(R.drawable.peippo);
                bottomLeft.setImageResource(R.drawable.peukaloinen);
                bottomRight.setImageResource(R.drawable.punatulkku);

                topLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playHuuhkaja();
                    }
                });
                topRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playPeippo();
                    }
                });
                bottomLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playPeukaloinen();
                    }
                });
                bottomRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playPunatulkku();
                    }
                });

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void playBear()
    {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.bear);
        mediaPlayer.start();
    }

    public void playWolf()
    {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.wolf);
        mediaPlayer.start();
    }
    public void playElephant()
    {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.elephant);
        mediaPlayer.start();
    }
    public void playLamb()
    {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.lamb);
        mediaPlayer.start();
    }

    public void playHuuhkaja()
    {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.huuhkaja_norther_eagle_owl);
        mediaPlayer.start();
    }

    public void playPeippo()
    {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.peippo_chaffinch);
        mediaPlayer.start();
    }
    public void playPeukaloinen()
    {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.peukaloinen_wren);
        mediaPlayer.start();
    }
    public void playPunatulkku()
    {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.punatulkku_northern_bullfinch);
        mediaPlayer.start();
    }
}
