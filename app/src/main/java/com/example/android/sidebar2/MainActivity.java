package com.example.android.sidebar2;

import android.content.Intent;
import android.support.v4.app.Fragment;///////////////////these are really important imports for FRAGMENTS
import android.support.v4.app.FragmentTransaction;



import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(this, LogoutActivity.class);////////////create an intent to change to the logout activity
        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        int id = menuItem.getItemId();///////get the ID of the clicked item
                        if (id == R.id.nav_camera) {
                            Log.w("clicked", "the camera was clicked");
                            ////////////////////////////////////////////////////////OPEN the CAMERA Fragment
                            Fragment myfragment = new EmailFeedbackFragment();
                            FragmentTransaction myTransaction = getSupportFragmentManager().beginTransaction();

                            myTransaction.replace(R.id.FragmentContainer, myfragment);////put my fragment into the fragment container
                            myTransaction.addToBackStack(null);
                            myTransaction.commit();

                        }
                        if(id==R.id.logout){
                            Log.w("clicked", "logout was clicked");
                            startActivity(intent);//////open the logout activity
                        }

                        return true;
                    }
                });


    }


}
