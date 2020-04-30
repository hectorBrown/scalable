package com.example.scalable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.scalable.profiles.Profiles
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListFabFragment : Fragment() {
    lateinit var add_profile: FloatingActionButton
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_fab, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_profile = view.findViewById(R.id.add_profile)
        add_profile.setOnClickListener { createProfile() }
    }

    fun createProfile() {
        val newProfile = Profile("New Profile", mutableListOf())
        Profiles.ITEMS.add(Profile("New Profile", mutableListOf()))
        Profiles.CurrProf = newProfile
        ProfileFileHandler.saveProfiles()
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

}
