package com.example.android.sidebar2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void LoginButtonPress(View view){
        final Intent intent = new Intent(this, MainActivity.class);////////////create an intent to change to the main activity class



        Log.w("checking", "Log in Button Pressed");
        EditText username_textedit = (EditText)findViewById(R.id.UserName);////identify the text edit that houses the username
        final String username = username_textedit.getText().toString();////get the username string
        EditText password_textedit = (EditText)findViewById(R.id.PassWord);////identify the text edit that houses the password
        final String password = password_textedit.getText().toString();////get the password string
Log.w("checking", username+" "+password);


        RequestQueue LoginQ = Volley.newRequestQueue(this);

String url = "https://www.anaesthesia-feedback.co.uk/APP/APP_login.php?username="+username+"&password="+password;
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //mTextView.setText("Response is: "+ response.substring(0,500));
                        Log.w("response", response);
                        String ddout = response;

if(ddout.equals("OK")){/////////////////////////////////////////////////////////////////////////note JAVAs weird way of comparing strings
    //Toast.makeText(LoginActivity.this, "from if statement going in", Toast.LENGTH_SHORT).show();///change activity here open main
    /////create shared preferences to be logged in.
    SharedPreferences.Editor editor = getSharedPreferences("InitialPrefs", MODE_PRIVATE).edit();
    editor.putString("username", username);
    editor.putString("password", password);
    editor.apply();

    startActivity(intent);//////open the main activity class
}
else{
    Toast.makeText(LoginActivity.this, ""+ddout, Toast.LENGTH_SHORT).show();////////////you arent getting in
}



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               
                Log.w("response", "that didn't work, no network!");
                Toast.makeText(LoginActivity.this, "no network", Toast.LENGTH_LONG).show();
            }

        });


// Add the request to the RequestQueue.
        LoginQ.add(stringRequest);

    }


}
