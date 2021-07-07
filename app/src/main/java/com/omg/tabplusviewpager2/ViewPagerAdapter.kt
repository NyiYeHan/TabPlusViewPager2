package com.omg.tabplusviewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private val fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {


    private var fragmentNameList: MutableList<FragmentName> = mutableListOf()
    private var fragmentList: MutableList<Fragment> = mutableListOf()


    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]


    enum class FragmentName {
        UPDATE,
        POPULAR,
        FOLLOWING,
        QUEQUE
    }

    fun addFragmentName(fragment: FragmentName) {
        fragmentNameList.add(fragment)
        notifyDataSetChanged()
    }

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
        notifyDataSetChanged()
    }


}