package com.omg.tabplusviewpager2;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.omg.tabplusviewpager2.child.ChildFragment;

public class ParentActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        viewPager = findViewById(R.id.myPager);
        SecondViewPagerAdapter adapter = new SecondViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChildFragment());
        adapter.addFragment(new TwoFragment());

        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabs);


        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setCustomView(R.layout.custom_tab_layout);
        }
        tabLayout.getTabAt(0).getCustomView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getCustomView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
//                ViewGroup.LayoutParams layoutParams = tab.getCustomView().getLayoutParams();
//                layoutParams.width = 100;
//                layoutParams.height = 100;
//                tab.getCustomView().setLayoutParams(layoutParams);


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));
//                ViewGroup.LayoutParams layoutParams = tab.getCustomView().getLayoutParams();
//                layoutParams.width = 20;
//                layoutParams.height = 20;
//                tab.getCustomView().setLayoutParams(layoutParams);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        new TabLayoutMediator(tabLayout, viewPager,
//                (tab, position) -> {
//                    tab.setText(((SecondViewPagerAdapter) (viewPager.getAdapter())).mFragmentNames[position]);//Sets tabs names as mentioned in ViewPagerAdapter fragmentNames array, this can be implemented in many different ways.
//                }
//        ).attach();
    }
}
