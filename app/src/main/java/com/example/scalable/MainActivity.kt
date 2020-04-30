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
    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        //boilerplate
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //json parsing -- load file
        val gson = Gson()
        val profileSave = File(filesDir.path + "profilesave.json")
        val profileListType = object : TypeToken<MutableList<Profile>>() {}.type
        Profiles.ITEMS.addAll(gson.fromJson(profileSave.readText(),profileListType))
        //test profile defaults
//        Profiles.ITEMS.add(Profile(0,"Grade 5 Saxophone",mutableListOf(
//            Scale('A', false),
//            Scale('A', true),
//            Scale('B', false),
//            Scale('B',true)
//        )))
//        Profiles.ITEMS.add(Profile(1, "Custom", mutableListOf(
//            Scale('C',false),
//            Scale('D',false)
//        )))
//        profileSave.writeText(gson.toJson(Profiles.ITEMS,profileListType))

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
