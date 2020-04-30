package com.example.scalable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import com.example.scalable.profiles.Profiles
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.lang.reflect.Type
import kotlin.reflect.typeOf


class MainActivity : AppCompatActivity(), ProfileFragment.OnListFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        //boilerplate
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        ProfileFileHandler.filesPath = filesDir.path

//        writeDebugProfiles()
        ProfileFileHandler.readProfiles()

    }
    fun writeDebugProfiles() {
        Profiles.ITEMS.add(Profile("Grade 5 Saxophone", mutableListOf(
            Scale('G', Scale.Range.Twelfth, sharp=true, articulation=Scale.Articulation.Slurred),
            Scale('G', Scale.Range.Twelfth, sharp=true, articulation=Scale.Articulation.Tongued),
            Scale('G', Scale.Range.Twelfth, majMin = Scale.MajMin.Melodic, sharp=true, articulation=Scale.Articulation.Tongued),
            Scale('G', Scale.Range.Twelfth, majMin = Scale.MajMin.Melodic, sharp=true, articulation=Scale.Articulation.Slurred),
            Scale('G', Scale.Range.Twelfth, majMin = Scale.MajMin.Harmonic, sharp=true, articulation=Scale.Articulation.Tongued),
            Scale('G', Scale.Range.Twelfth, majMin = Scale.MajMin.Harmonic, sharp=true, articulation=Scale.Articulation.Slurred),
            Scale('A', Scale.Range.Twelfth, articulation=Scale.Articulation.Slurred),
            Scale('A', Scale.Range.Twelfth, articulation=Scale.Articulation.Tongued),
            Scale('A', Scale.Range.Twelfth, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Tongued),
            Scale('A', Scale.Range.Twelfth, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Slurred),
            Scale('A', Scale.Range.Twelfth, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Tongued),
            Scale('A', Scale.Range.Twelfth, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Slurred),
            Scale('B', Scale.Range.TwoOct, articulation=Scale.Articulation.Slurred),
            Scale('B', Scale.Range.TwoOct, articulation=Scale.Articulation.Tongued),
            Scale('B', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Tongued),
            Scale('B', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Slurred),
            Scale('B', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Tongued),
            Scale('B', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Slurred),
            Scale('D', Scale.Range.TwoOct, articulation=Scale.Articulation.Slurred),
            Scale('D', Scale.Range.TwoOct, articulation=Scale.Articulation.Tongued),
            Scale('D', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Tongued),
            Scale('D', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Slurred),
            Scale('D', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Tongued),
            Scale('D', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Slurred),
            Scale('F', Scale.Range.TwoOct, articulation=Scale.Articulation.Slurred),
            Scale('F', Scale.Range.TwoOct, articulation=Scale.Articulation.Tongued),
            Scale('F', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Tongued),
            Scale('F', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Slurred),
            Scale('F', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Tongued),
            Scale('F', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Slurred),
            Scale('G', Scale.Range.Oct, articulation=Scale.Articulation.Slurred, thirds=true),
            Scale('G', Scale.Range.Oct, articulation=Scale.Articulation.Tongued, thirds=true),
            Scale('A', Scale.Range.Twelfth, articulation=Scale.Articulation.Slurred, chromatic=true),
            Scale('A', Scale.Range.Twelfth, articulation=Scale.Articulation.Tongued, chromatic=true),
            Scale('G', Scale.Range.Twelfth, articulation=Scale.Articulation.Slurred, chromatic=true, sharp=true),
            Scale('G', Scale.Range.Twelfth, articulation=Scale.Articulation.Tongued, chromatic=true, sharp=true),
            Scale('D', Scale.Range.TwoOct, articulation=Scale.Articulation.Slurred, chromatic=true),
            Scale('D', Scale.Range.TwoOct, articulation=Scale.Articulation.Tongued, chromatic=true),
            Scale('G', Scale.Range.Twelfth, majMin=Scale.MajMin.Major, articulation=Scale.Articulation.Slurred, arpeggio=true, sharp=true),
            Scale('G', Scale.Range.Twelfth, majMin=Scale.MajMin.Major, articulation=Scale.Articulation.Tongued, arpeggio=true, sharp=true),
            Scale('G', Scale.Range.Twelfth, majMin=Scale.MajMin.Harmonic, articulation=Scale.Articulation.Slurred, arpeggio=true, sharp=true),
            Scale('G', Scale.Range.Twelfth, majMin=Scale.MajMin.Harmonic, articulation=Scale.Articulation.Tongued, arpeggio=true, sharp=true),
            Scale('G', Scale.Range.Twelfth, majMin=Scale.MajMin.Melodic, articulation=Scale.Articulation.Slurred, arpeggio=true, sharp=true),
            Scale('G', Scale.Range.Twelfth, majMin=Scale.MajMin.Melodic, articulation=Scale.Articulation.Tongued, arpeggio=true, sharp=true),
            Scale('A', Scale.Range.Twelfth, majMin=Scale.MajMin.Major, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('A', Scale.Range.Twelfth, majMin=Scale.MajMin.Major, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('A', Scale.Range.Twelfth, majMin=Scale.MajMin.Harmonic, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('A', Scale.Range.Twelfth, majMin=Scale.MajMin.Harmonic, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('A', Scale.Range.Twelfth, majMin=Scale.MajMin.Melodic, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('A', Scale.Range.Twelfth, majMin=Scale.MajMin.Melodic, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('B', Scale.Range.TwoOct, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('B', Scale.Range.TwoOct, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('B', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('B', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('B', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('B', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('D', Scale.Range.TwoOct, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('D', Scale.Range.TwoOct, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('D', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('D', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('D', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('D', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('F', Scale.Range.TwoOct, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('F', Scale.Range.TwoOct, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('F', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('F', Scale.Range.TwoOct, majMin = Scale.MajMin.Melodic, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('F', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Tongued, arpeggio=true),
            Scale('F', Scale.Range.TwoOct, majMin = Scale.MajMin.Harmonic, articulation=Scale.Articulation.Slurred, arpeggio=true),
            Scale('C', Scale.Range.Twelfth, sharp=true, articulation=Scale.Articulation.Slurred, seventh=Scale.Seventh.Dominant),
            Scale('C', Scale.Range.Twelfth, sharp=true, articulation=Scale.Articulation.Tongued, seventh=Scale.Seventh.Dominant),
            Scale('D', Scale.Range.Twelfth, articulation=Scale.Articulation.Slurred, seventh=Scale.Seventh.Dominant),
            Scale('D', Scale.Range.Twelfth, articulation=Scale.Articulation.Tongued, seventh=Scale.Seventh.Dominant),
            Scale('G', Scale.Range.TwoOct, articulation=Scale.Articulation.Slurred, seventh=Scale.Seventh.Dominant),
            Scale('G', Scale.Range.TwoOct, articulation=Scale.Articulation.Tongued, seventh=Scale.Seventh.Dominant),
            Scale('G', Scale.Range.Twelfth, sharp=true, articulation=Scale.Articulation.Slurred, seventh=Scale.Seventh.Diminished),
            Scale('G', Scale.Range.Twelfth, sharp=true, articulation=Scale.Articulation.Tongued, seventh=Scale.Seventh.Diminished),
            Scale('A', Scale.Range.Twelfth, articulation=Scale.Articulation.Slurred, seventh=Scale.Seventh.Diminished),
            Scale('A', Scale.Range.Twelfth, articulation=Scale.Articulation.Tongued, seventh=Scale.Seventh.Diminished),
            Scale('D', Scale.Range.TwoOct, articulation=Scale.Articulation.Slurred, seventh=Scale.Seventh.Diminished),
            Scale('D', Scale.Range.TwoOct, articulation=Scale.Articulation.Tongued, seventh=Scale.Seventh.Diminished))))
        ProfileFileHandler.saveProfiles()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onListFragmentInteraction(item: Profile?) {
        Profiles.CurrProf = item
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

}
