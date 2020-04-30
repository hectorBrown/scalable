package com.example.scalable

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyFragmentPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getItem(pos: Int): Fragment {
       return NoteFragment.newInstance((pos + 65).toChar().toString())
    }
    override fun getCount() = 8
    override fun getPageTitle(pos: Int): String {
        return ((pos + 65).toChar().toString())
    }
}