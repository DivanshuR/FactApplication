package com.rohatgi.developer.factcheck;

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
                .setImage(R.drawable.about)
                .setDescription("Interesting|Hidden and Meaningful Facts About Numbers. Make sure you're always connected to internet and learning.")
                .addItem(new Element().setTitle("Version 2.0"))
                .addGroup("Connect with the Developer")
                .addFacebook("divanshu.rohatgi6")
                .addInstagram("divanshurohatgi")
                .addGitHub("DivanshuR")

                .create();

        setContentView(aboutPage);



    }
}
