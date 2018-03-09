package com.rohatgi.developer.factcheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FrontActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

//      ParticleView mParticleView = findViewById(R.id.front_text);
//      mParticleView.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
//            @Override
//            public void onAnimationEnd() {
////                Toast.makeText(FrontActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
////                startActivity(new Intent(FrontActivity.this,DesignActivity.class));
//                startActivity(new Intent(FrontActivity.this,DesignActivity.class));
//                finish();
//            }
//        });
//
//      mParticleView.startAnim();




        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1200);
                    Intent intent = new Intent(getApplicationContext(), DesignActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();





    }




}