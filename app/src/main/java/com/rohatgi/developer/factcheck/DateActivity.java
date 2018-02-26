package com.rohatgi.developer.factcheck;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class DateActivity extends AppCompatActivity {


    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        final TextView show=  findViewById(R.id.show);
        final EditText datetext=  findViewById(R.id.dateText);
        final Button btndate=  findViewById(R.id.btndate);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });





        datetext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });


        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String editTextValue = datetext.getText().toString();


                if (editTextValue.isEmpty()||editTextValue.equals("#")||editTextValue.equals("@")) {


                    //Toast.makeText(getApplicationContext(),"Please Enter number ",Toast.LENGTH_SHORT).show();

                    Random rand = new Random();
                    int number = rand.nextInt(1000);
                    String myString = String.valueOf(number);

                    //Even if the editText is empty will generate random facts.
                    // Instantiate the RequestQueue.
                    RequestQueue queue = Volley.newRequestQueue(getApplication());
                    String url = "http://numbersapi.com/" + number + "/" + number + "/date";

// Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // Displaying the response string.
                                    show.setText(response);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            show.setText(R.string.Error_Message);
                        }
                    });
// Add the request to the RequestQueue.
                    queue.add(stringRequest);


                } else {

                    // Instantiate the RequestQueue.
                    RequestQueue queue = Volley.newRequestQueue(getApplication());
                    String url = "http://numbersapi.com/" + editTextValue + "/date";

// Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // Displaying the response string.
                                    show.setText(response);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            show.setText(R.string.Error_Message);
                        }
                    });
// Add the request to the RequestQueue.
                    queue.add(stringRequest);


                }

            }
        });




    }
    public void hideKeyboard(View v) {

        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);

        } catch (NullPointerException exception) {

            Toast.makeText(this, "Keyboard Hidding Error", Toast.LENGTH_SHORT).show();
        }
    }
}
