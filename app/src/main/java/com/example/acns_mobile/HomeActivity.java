package com.example.acns_mobile;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 5000; // 5 seconds
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ImageView imageViewBars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize views
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        imageViewBars = findViewById(R.id.imageViewBars);

        // Set up the Toolbar as the action bar
        setSupportActionBar(toolbar);

        // Set the title to an empty string (remove the default title)
        getSupportActionBar().setTitle("");

        // Set up the ActionBarDrawerToggle to enable the sidebar
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // Set up the navigation view item click listener
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation item click
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        // Display a message or perform an action for Home
                        Toast.makeText(HomeActivity.this, "Home Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    // Add similar cases for other menu items
                }

                // Close the drawer
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        // Set up the bars icon click listener
        imageViewBars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the drawer when the bars icon is clicked
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // Remove the automatic navigation to HomeActivity to see the navigation drawer
        // Use a Handler to delay the navigation by SPLASH_DURATION milliseconds
        new Handler().postDelayed(() -> {
            // Navigate to the next screen (HomeActivity)
            //Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
            //startActivity(intent);
            //finish(); // Finish the current activity to prevent going back
        }, SPLASH_DURATION);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle sidebar toggle
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
