package com.webovix.campusring.ui.dashboard;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.webovix.campusring.R;
import com.webovix.campusring.ui.dashboard.adapters.OuterRVA;
import com.webovix.campusring.ui.dashboard.misc.StoryText;
import com.webovix.campusring.ui.dashboard.models.ImagesList;
import com.webovix.campusring.ui.dashboard.models.Story;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    private static final int REQUEST_VID_GET = 2;
    private final static int REQUEST_IMAGE_GET = 1;
    private VideoView videoView;
    private List<Story> stories, storiesviewed;
    private ImageButton imageButton;
    private AlertDialog dialog;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        TextView addToStory = view.findViewById(R.id.addToStoryButton);
        CardView addStoryCardview = view.findViewById(R.id.cardView3);
        imageButton = view.findViewById(R.id.storyImageButton);
        videoView = view.findViewById(R.id.stroyVideo);

        prepareData();
        setupRVA(view);

        addStoryCardview.setOnClickListener(this);
        addToStory.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // fetch image
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            Uri mImageUri = data.getData();
            InputStream imageStream = null;
            assert mImageUri != null;
            try {
                imageStream = requireActivity().getContentResolver().openInputStream(mImageUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imageButton.setVisibility(View.VISIBLE);
            imageButton.setScaleType(ImageButton.ScaleType.FIT_XY);
            imageButton.setImageBitmap(BitmapFactory.decodeStream(imageStream));
        }
        // fetch video
        else if (requestCode == REQUEST_VID_GET && resultCode == RESULT_OK) {
            dialog.dismiss();
            Uri VideoUri = data.getData();
            assert VideoUri != null;
            videoView.setVideoPath(VideoUri.toString());
            videoView.setVisibility(View.VISIBLE);
            videoView.start();
        }

    }

    // prepare data to display
    private void prepareData() {

        List<ImagesList> imagesList = new ArrayList<>();
        stories = new ArrayList<>();
        storiesviewed = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            ImagesList im = new ImagesList("image" + i);
            imagesList.add(im);
        }

        List<ImagesList> imagesList2 = new ArrayList<>();
        for (int i = 3; i < 6; i++) {
            ImagesList im = new ImagesList("image" + i);
            imagesList2.add(im);
        }

        List<ImagesList> imagesList3 = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            ImagesList im = new ImagesList("image" + i);
            imagesList3.add(im);
        }

        Story s1 = new Story("user1", imagesList);
        Story s2 = new Story("user2", imagesList);
        Story s3 = new Story("user3", imagesList2);
        Story s4 = new Story("user4", imagesList3);
        stories.add(s1);
        stories.add(s2);
        stories.add(s3);
        stories.add(s4);

        storiesviewed.add(s1);
        storiesviewed.add(s2);
        storiesviewed.add(s3);
        storiesviewed.add(s3);


    }

    // Recyclerview adapter setting
    void setupRVA(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recentStoryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        OuterRVA outerRVA = new OuterRVA(getActivity(), stories);
        recyclerView.setAdapter(outerRVA);
        outerRVA.notifyDataSetChanged();

        RecyclerView recyclerView2 = view.findViewById(R.id.viewedStoryRecyclerView);
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        OuterRVA outerRVAviewed = new OuterRVA(getActivity(), storiesviewed);
        recyclerView2.setAdapter(outerRVAviewed);
        outerRVAviewed.notifyDataSetChanged();
    }

    //dialog box to add image video text to story
    void createDilog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.dashboard_selection_dilog, null);

        Button img = view.findViewById(R.id.imgButton);
        Button vid = view.findViewById(R.id.vidButton);
        Button txt = view.findViewById(R.id.txtButton);
        Button close = view.findViewById(R.id.closeButton);

        alertDialogBuilder.setView(view);
        dialog = alertDialogBuilder.create();
        dialog.show();

        img.setOnClickListener(this);
        vid.setOnClickListener(this);
        txt.setOnClickListener(this);
        close.setOnClickListener(this);
    }

    // click behaviors
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.cardView3:
            case R.id.storyImageButton:
                createDilog();
                break;

            case R.id.addToStoryButton:
                upload();
                break;

            case R.id.imgButton:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                    startActivityForResult(intent, REQUEST_IMAGE_GET);
                }
                dialog.dismiss();
                break;

            case R.id.vidButton:
                Intent vidintent = new Intent(Intent.ACTION_GET_CONTENT);
                vidintent.setType("video/*");
                if (vidintent.resolveActivity(requireActivity().getPackageManager()) != null) {
                    startActivityForResult(vidintent, REQUEST_VID_GET);
                }
                break;

            case R.id.txtButton:
                dialog.dismiss();
                Fragment fragment = new StoryText();
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.closeButton:
                dialog.dismiss();
                break;
        }
    }

    // uploading to storage
    private void upload() {
        Toast.makeText(getActivity(), "Adding to your story", Toast.LENGTH_SHORT).show();
    }

}


// A section to enter my story
// a button to import image from gallery or camera
// add details to it
// attach timestamp to it
// upload using a framework in an API using post

// Create new stroies Recyclerview
// contains all new stories (Status.view != seen)

// Create already watched stories RecyclerView (Status.view == seen)

// create a lst row
// fetch data using API
// create list view display images horizontally
// display date(time), profile pic, name, count of post and pitures itself

