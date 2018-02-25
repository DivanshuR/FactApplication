package com.rohatgi.developer.factcheck;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Random;

public class DateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        final TextView show=  findViewById(R.id.show);
        final EditText datetext=  findViewById(R.id.dateText);
        final Button btndate=  findViewById(R.id.btndate);


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
                            show.setText("Sorry.This app only understands numbers.");
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
                            show.setText("Sorry.This app only understands numbers.");
                        }
                    });
// Add the request to the RequestQueue.
                    queue.add(stringRequest);


                }

            }
        });




    }
}
