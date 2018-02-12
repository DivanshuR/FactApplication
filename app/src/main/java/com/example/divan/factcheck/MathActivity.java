package com.example.divan.factcheck;

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

public class MathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final TextView show=  findViewById(R.id.show);
        final EditText mathtext=  findViewById(R.id.mathText);
        final Button btnmath=  findViewById(R.id.btnmath);


        btnmath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String editTextValue = mathtext.getText().toString();


                if (editTextValue.isEmpty()||editTextValue.equals("#")||editTextValue.equals("@")) {


                    //Toast.makeText(getApplicationContext(),"Please Enter number ",Toast.LENGTH_SHORT).show();

                    Random rand = new Random();
                    int number = rand.nextInt(10000);
                    String myString = String.valueOf(number);

                    //Even if the editText is empty will generate random facts.
                    // Instantiate the RequestQueue.
                    RequestQueue queue = Volley.newRequestQueue(getApplication());
                    String url = "http://numbersapi.com/" + number + "/math";

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
                            show.setText("Uh oh, we don't understand that or Check your Connection. ");
                        }
                    });
// Add the request to the RequestQueue.
                    queue.add(stringRequest);


                } else {

                    // Instantiate the RequestQueue.
                    RequestQueue queue = Volley.newRequestQueue(getApplication());
                    String url = "http://numbersapi.com/" + editTextValue + "/math";

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
                            show.setText("Uh oh, we don't understand that or Check your Connection. ");
                        }
                    });
// Add the request to the RequestQueue.
                    queue.add(stringRequest);


                }

            }
        });




    }
}
