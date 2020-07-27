package com.webovix.campusring.ui.misc;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webovix.campusring.R;

public class MiscFragment extends Fragment {

    private View miscfrag;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        miscfrag=inflater.inflate(R.layout.fragment_home , container, false);
        return miscfrag;
    }

}
