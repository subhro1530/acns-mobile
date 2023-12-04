package com.example.acns_mobile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 8000; // 10 seconds
    private boolean videoCompleted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.intro;
        videoView.setVideoURI(Uri.parse(videoPath));
        videoView.start();

        // Use a Handler to delay the navigation by SPLASH_DURATION milliseconds
        new Handler().postDelayed(() -> {
            videoCompleted = true;
            navigateToHome();
        }, SPLASH_DURATION);
    }

    private void navigateToHome() {
        if (videoCompleted) {
            // Navigate to the next screen (HomeActivity)
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Finish the current activity to prevent going back
        }
    }
}
