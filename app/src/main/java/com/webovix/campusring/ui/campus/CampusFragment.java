package com.webovix.campusring.ui.campus;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webovix.campusring.R;

public class CampusFragment extends Fragment {

    private View campusfrag;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        campusfrag=inflater.inflate(R.layout.campus_fragment , container, false);
        return campusfrag;
    }

}
