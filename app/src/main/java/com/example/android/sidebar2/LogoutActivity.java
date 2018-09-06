package com.example.android.sidebar2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        Log.w("logout", "logging out");
        SharedPreferences.Editor clear_preferences = getSharedPreferences("InitialPrefs", MODE_PRIVATE).edit();
        clear_preferences.clear();
        clear_preferences.apply();
        Log.w("logout", "cleared preferences");
    }
}
