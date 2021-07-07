package com.omg.tabplusviewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SocialFragment : Fragment() {

    private lateinit var mAdapter: ViewPagerFragmentAdapter
    private lateinit var mViewPager: ViewPager
    private lateinit var mTabLayout: TabLayout
    private lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mView = inflater.inflate(R.layout.fragment_social, container, false)
        mViewPager = mView.findViewById(R.id.socialPager)
        mTabLayout = mView.findViewById(R.id.socialTabLayout)
        setupViewPager()
        return mView
    }

    private fun setupViewPager() {
        mAdapter = ViewPagerFragmentAdapter(fragment = parentFragmentManager)
        mAdapter.addFragment(ThreeFragment())
        mAdapter.addFragment(ThreeFragment())
        mTabLayout.setupWithViewPager(mViewPager)

    }
}