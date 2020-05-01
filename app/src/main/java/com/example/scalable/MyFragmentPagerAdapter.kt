package com.example.scalable

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.scalable.noteeditor.NoteSpecificScaleListFragment

class MyFragmentPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getItem(pos: Int): Fragment {
       return NoteSpecificScaleListFragment.newInstance((pos + 65).toChar().toString(), 1)
    }
    override fun getCount() = 7
    override fun getPageTitle(pos: Int): String {
        return ((pos + 65).toChar().toString())
    }
}