package com.example.divan.factcheck;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private Button trivia_btn,math_btn,year_btn,date_btn;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_feedback:

                        startActivity(new Intent(MainActivity.this, FeedbackActivity.class));
                        break;

                    case R.id.ic_about:
                        startActivity(new Intent(MainActivity.this, AboutActivity.class));
                        break;

                    case R.id.ic_share:
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "APP NAME (Open it in Google Play Store to Download the Application)");

                        startActivity(Intent.createChooser(sharingIntent, "Share via"));
                        break;
                }
                return true;
            }
        });

        date_btn = findViewById(R.id.button1);
        trivia_btn = findViewById(R.id.button2);
        math_btn = findViewById(R.id.button3);
        year_btn = findViewById(R.id.button4);

    }

    public void triviaBtn(View view) {

        trivia_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,TriviaActivity.class);
                startActivity(intent);

            }
        });
    }

    public void dateBtn(View view) {
        date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void yearBtn(View view) {
        year_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void mathBtn(View view) {
        math_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

