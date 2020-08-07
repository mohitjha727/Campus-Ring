package com.webovix.campusring.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.webovix.campusring.R;

public class HomeFragment extends Fragment {


    private View homefragment;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homefragment = inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager viewPager = homefragment.findViewById(R.id.viewPager);
//       PageAdapter pageAdapter=new PageAdapter(getChildFragmentManager(),tabLayout.getTabCount());
//        TabLayout tabLayout = homefragment.findViewById(R.id.tablayout);
        TabItem tabChats = homefragment.findViewById(R.id.tabChats);
        TabItem tabNearby = homefragment.findViewById(R.id.tabNearby);
        TabItem tabActive = homefragment.findViewById(R.id.tabActive);
        TabItem tabGroups = homefragment.findViewById(R.id.tabGroups);

        return homefragment;
    }
}
