package com.webovix.campusring.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.webovix.campusring.CreatePostActivity;
import com.webovix.campusring.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class NotificationsFragment extends Fragment {

    private View notificationfrag;
    private CircleImageView addpost;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationfrag=inflater.inflate(R.layout.fragment_notifications , container, false);
        addpost=(CircleImageView)notificationfrag.findViewById(R.id.addpost);
        addpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CreatePostActivity.class);
                startActivity(intent);
            }
        });
        return notificationfrag;
    }


}
