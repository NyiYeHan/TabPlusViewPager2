package com.omg.tabplusviewpager2.child;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.omg.tabplusviewpager2.R;
import com.omg.tabplusviewpager2.SecondViewPagerAdapter;
import com.omg.tabplusviewpager2.ThreeFragment;
import com.omg.tabplusviewpager2.TwoFragment;

public class ChildFragment extends Fragment {
    private ViewPager viewPager;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.activity_child, container, false);


        viewPager = mView.findViewById(R.id.childPager);

        SecondViewPagerAdapter adapter = new SecondViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new TwoFragment());
        adapter.addFragment(new ThreeFragment());

        viewPager.setAdapter(adapter);
        TabLayout tabLayout = mView.findViewById(R.id.childTabs);
        tabLayout.setupWithViewPager(viewPager);
        return mView;
    }
}
