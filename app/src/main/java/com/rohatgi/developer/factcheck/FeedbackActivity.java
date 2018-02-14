package com.rohatgi.developer.factcheck;

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
                .setImage(R.drawable.about)
                .setDescription("Send Us Feedback")
                .addGroup("Any Suggestions?")
                .addEmail("rohatgideveloper@gmail.com")
                .addPlayStore("com.rohatgi.developer.factcheck")
                .create();

        setContentView(aboutPage);


    }
}
