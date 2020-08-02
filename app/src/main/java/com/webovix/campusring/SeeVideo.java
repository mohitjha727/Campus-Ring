package com.webovix.campusring;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class SeeVideo extends AppCompatActivity {
    private VideoView videopost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_video);
        getSupportActionBar().setTitle("Video");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        videopost=(VideoView)findViewById(R.id.videoview);
        Uri uri=Uri.parse(getIntent().getExtras().getString("uri"));
        videopost.setVideoURI(uri);
        videopost.start();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
