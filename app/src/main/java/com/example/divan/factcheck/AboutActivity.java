package com.example.divan.factcheck;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.doubt)
                .setDescription("Interesting Facts About Numbers")
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("Connect with us")
                .addEmail("divanshu.rohatgi6@gmail.com")
                .addFacebook("divanshu.rohatgi6")
                .addInstagram("divanshurohatgi")
                .create();

        setContentView(aboutPage);



    }
}
