package com.webovix.campusring.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.webovix.campusring.R;

public class HomeFragment extends Fragment {


    private View homefragment;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homefragment= inflater.inflate(R.layout.fragment_home , container, false);
//        ViewPager viewPager = findViewById(R.id.viewPager);
//        PageAdapter pageAdapter=new PageAdapter(getChildFragmentManager(),tabLayout.getTabCount());;
//        TabLayout tabLayout = (homefragment)findViewById(R.id.tablayout);
//        TabItem tabChats = (homefragment)findViewById(R.id.tabChats);
//        TabItem tabNearby = findViewById(R.id.tabNearby);
//        TabItem tabActive = findViewById(R.id.tabActive);
//        TabItem tabGroups = findViewById(R.id.tabGroups);
//
        return homefragment;
    }
}
