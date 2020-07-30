package com.webovix.campusring.ui.dashboard;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.webovix.campusring.R;
import com.webovix.campusring.ui.dashboard.adapters.OuterRVA;
import com.webovix.campusring.ui.dashboard.models.ImagesList;
import com.webovix.campusring.ui.dashboard.models.Story;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class DashboardFragment extends Fragment {

    private ImageButton imageButton;
    private TextView addtostory;
    OuterRVA outerRVA,outerRVAviewed;
    List<Story> stories,storiesviewed;
    List<ImagesList> imagesList, imagesList2,imagesList3;
    private final static int REQUEST_IMAGE_GET = 1;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        imageButton = view.findViewById(R.id.storyImageButton);
        addtostory= view.findViewById(R.id.addToStoryButton);
        prepareData();
        setupRVA(view);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                    startActivityForResult(intent, REQUEST_IMAGE_GET);
                } } });

        addtostory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Adding to your stories", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            Uri mImageUri = data.getData();
            InputStream imageStream = null;
            try {
                imageButton.setScaleType(ImageButton.ScaleType.FIT_XY);
                assert mImageUri != null;
                imageStream = requireActivity().getContentResolver().openInputStream(mImageUri);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imageButton.setImageBitmap(BitmapFactory.decodeStream(imageStream));
        }}

    private void prepareData() {

        imagesList = new ArrayList<>();
        stories = new ArrayList<>();
        storiesviewed = new ArrayList<>();

        for (int i = 0; i <6 ; i++) {
            ImagesList im = new ImagesList("image"+i);
            imagesList.add(im);
        }

        imagesList2 = new ArrayList<>();
        for (int i = 3; i <6 ; i++) {
            ImagesList im = new ImagesList("image"+i);
            imagesList2.add(im);
        }

        imagesList3 = new ArrayList<>();
        for (int i = 1; i <9 ; i++) {
            ImagesList im = new ImagesList("image"+i);
            imagesList3.add(im);
        }

            Story s1 = new Story("user1",imagesList);
            Story s2 = new Story("user2",imagesList);
            Story s3 = new Story("user3",imagesList2);
            Story s4 = new Story("user4",imagesList3);
            stories.add(s1);
            stories.add(s2);
            stories.add(s3);
            stories.add(s4);

            storiesviewed.add(s1);
            storiesviewed.add(s2);
            storiesviewed.add(s3);
            storiesviewed.add(s3);



    }

    void setupRVA(View view){
        RecyclerView recyclerView = view.findViewById(R.id.recentStoryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        outerRVA = new OuterRVA(getActivity(),stories);
        recyclerView.setAdapter(outerRVA);
        outerRVA.notifyDataSetChanged();

        RecyclerView recyclerView2 = view.findViewById(R.id.viewedStoryRecyclerView);
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        outerRVAviewed = new OuterRVA(getActivity(),storiesviewed);
        recyclerView2.setAdapter(outerRVAviewed);
        outerRVAviewed.notifyDataSetChanged();}
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

