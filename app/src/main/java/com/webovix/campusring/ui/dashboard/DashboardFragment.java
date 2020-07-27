package com.webovix.campusring.ui.dashboard;

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

import com.webovix.campusring.R;

public class DashboardFragment extends Fragment {

    private View dashboardfragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardfragment= inflater.inflate(R.layout.fragment_dashboard , container, false);
        return dashboardfragment;
    }
}
