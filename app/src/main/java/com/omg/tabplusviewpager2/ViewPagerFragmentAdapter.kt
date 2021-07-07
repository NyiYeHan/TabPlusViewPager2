package com.omg.tabplusviewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerFragmentAdapter(private val fragment: FragmentManager) :
    FragmentStatePagerAdapter(fragment) {


    private var fragmentNameList: MutableList<FragmentName> = mutableListOf()
    private var fragmentList: MutableList<Fragment> = mutableListOf()


//    override fun getItemCount(): Int = fragmentList.size
//
//    override fun createFragment(position: Int): Fragment = fragmentList[position]


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

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return fragmentList[0]
            1 -> return fragmentList[1]
        }
        return fragmentList[0]
    }


}