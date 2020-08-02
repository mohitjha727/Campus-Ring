package com.webovix.campusring.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.webovix.campusring.CommentsActivity;
import com.webovix.campusring.CreatePostActivity;
import com.webovix.campusring.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class NotificationsFragment extends Fragment {

    private View notificationfrag;
    private CircleImageView addpost;
    private ImageView likebtn,dislikebtn,likebtnclr,dislikebtnclr,sharebtn,comments;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationfrag=inflater.inflate(R.layout.fragment_notifications , container, false);
        addpost=(CircleImageView)notificationfrag.findViewById(R.id.addpost);
        likebtn=(ImageView)notificationfrag.findViewById(R.id.likebtn);
        likebtnclr=(ImageView)notificationfrag.findViewById(R.id.likebtnclr);
        dislikebtn=(ImageView)notificationfrag.findViewById(R.id.dislikebtn);
        dislikebtnclr=(ImageView)notificationfrag.findViewById(R.id.dislikebtnclr);
        sharebtn=(ImageView)notificationfrag.findViewById(R.id.sharebtn);
        comments=(ImageView)notificationfrag.findViewById(R.id.cmntbtn);
        addpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CreatePostActivity.class);
                startActivity(intent);
            }
        });
        likebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likebtnclr.setVisibility(View.VISIBLE);
                likebtnclr.setEnabled(true);
                likebtn.setVisibility(View.INVISIBLE);
                likebtn.setEnabled(false);
                dislikebtnclr.setVisibility(View.INVISIBLE);
                dislikebtnclr.setEnabled(false);
                dislikebtn.setEnabled(true);
                dislikebtn.setVisibility(View.VISIBLE);
            }
        });
        likebtnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likebtn.setVisibility(View.VISIBLE);
                likebtn.setEnabled(true);
                likebtnclr.setEnabled(false);
                likebtnclr.setVisibility(View.INVISIBLE);

            }
        });
        dislikebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dislikebtnclr.setVisibility(View.VISIBLE);
                dislikebtnclr.setEnabled(true);
                dislikebtn.setVisibility(View.INVISIBLE);
                dislikebtn.setEnabled(false);
                likebtnclr.setVisibility(View.INVISIBLE);
                likebtnclr.setEnabled(false);
                likebtn.setVisibility(View.VISIBLE);
                likebtn.setEnabled(true);
            }
        });
        dislikebtnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dislikebtn.setVisibility(View.VISIBLE);
                dislikebtn.setEnabled(true);
                dislikebtnclr.setVisibility(View.INVISIBLE);
                dislikebtnclr.setEnabled(false);
            }
        });

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent =   new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Share post");
                String app_url = " Hello, Watch this post";
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });

        comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent=new Intent(getContext(), CommentsActivity.class);
             startActivity(intent);
            }
        });
        return notificationfrag;
    }


}
