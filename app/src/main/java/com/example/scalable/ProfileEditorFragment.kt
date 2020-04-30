package com.example.scalable

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.scalable.profiles.Profiles
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ProfileEditorFragment() : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_editor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.start_slides).setOnClickListener { switchActivity(it) }
        view.findViewById<TextView>(R.id.profile_name).text = Profiles.CurrProf?.name
        view.findViewById<TabLayout>(R.id.tabLayout).setupWithViewPager(view.findViewById<ViewPager>(R.id.viewPager))
        view.findViewById<ViewPager>(R.id.viewPager).adapter = MyFragmentPagerAdapter(childFragmentManager)
    }

    fun switchActivity(view: View) {
        val intent = Intent(context, Slides::class.java)
        startActivity(intent)
    }
}
