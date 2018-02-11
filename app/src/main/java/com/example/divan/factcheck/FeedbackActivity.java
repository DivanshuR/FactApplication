package com.example.divan.factcheck;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.doubt)
                .setDescription("Feedback")
                .addGroup("Any Suggestions?")
                .addEmail("divanshu.rohatgi6@gmail.com")
                .addPlayStore("com.example.divan.factcheck")
                .create();

        setContentView(aboutPage);


    }
}
