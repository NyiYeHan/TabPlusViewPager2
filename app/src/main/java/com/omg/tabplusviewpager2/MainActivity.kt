package com.omg.tabplusviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: ViewPagerAdapter
    private lateinit var mViewPager: ViewPager2
    private lateinit var mTabLayout: TabLayout
    private lateinit var mView: View
    private lateinit var tvCategory: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewPager = findViewById(R.id.pager)
        mTabLayout = findViewById(R.id.tabLayout)

//        mViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//
//                if (position == mTabLayout.selectedTabPosition) {
//                    mTabLayout.getTabAt(position)?.customView.let {
//                        it!!.setBackgroundColor(
//                            ContextCompat.getColor(
//                                applicationContext,
//                                R.color.black
//                            )
//                        )
//                        tvCategory = it.findViewById(R.id.tvCategory)
//                        tvCategory.text = "selected"
//                    }
//                } else {
//                    mTabLayout.getTabAt(position)?.customView.let {
//                        it!!.setBackgroundColor(
//                            ContextCompat.getColor(
//                                applicationContext,
//                                android.R.color.transparent
//                            )
//                        )
//                        tvCategory = it.findViewById(R.id.tvCategory)
//                        tvCategory.text = "selected"
//                    }
//                }
//
//            }
//
//        })

        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView.let {
                    it!!.setBackgroundColor(
                        ContextCompat.getColor(
                            applicationContext,
                            android.R.color.transparent
                        )
                    )
                    tvCategory = it.findViewById(R.id.tvCategory)
                    tvCategory.text = "unselected"

                    val param = it.layoutParams
                    param.width = 50
                    param.height = 50
                    it.layoutParams = param

                    tab?.customView = it
                }

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView.let {
                    it!!.setBackgroundColor(
                        ContextCompat.getColor(
                            applicationContext,
                            R.color.black
                        )
                    )
                    tvCategory = it.findViewById(R.id.tvCategory)
                    tvCategory.text = "selected"
                    val param = it.layoutParams
                    param.width = 1000
                    param.height = 1000
                    it.layoutParams = param

                    tab?.customView = it
                }
            }


        })

//        mView = layoutInflater.inflate(R.layout.custom_tab_layout, mTabLayout, false)
//        tvCategory = mView.findViewById(R.id.tvCategory)
        setUpViewPager()

    }

    private fun setUpViewPager() {
        mAdapter = ViewPagerAdapter(this)
        mAdapter.addFragment(SocialFragment())
        mAdapter.addFragment(TwoFragment())



        mViewPager.adapter = mAdapter


        mViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        TabLayoutMediator(mTabLayout, mViewPager) { tab, position ->
            when (position) {
                0 -> {
                    mView = layoutInflater.inflate(R.layout.custom_tab_layout, mTabLayout, false)
                    tvCategory = mView.findViewById(R.id.tvCategory)
                    tvCategory.text = "Social"


                }
                1 -> {
                    mView = layoutInflater.inflate(R.layout.custom_tab_layout, mTabLayout, false)
                    tvCategory = mView.findViewById(R.id.tvCategory)
                    tvCategory.text = "Yo What's Up"

                }

            }
            tab.customView = mView

        }.attach()


    }
}