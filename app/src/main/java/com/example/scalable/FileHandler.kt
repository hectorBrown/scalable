package com.example.scalable

import com.example.scalable.profiles.Profiles
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

object ProfileFileHandler {
    val gson = Gson()
    val profileListType = object : TypeToken<MutableList<Profile>>() {}.type
    var filesPath : String? = null

    fun saveProfiles() {
        val profileSaveFile = File(filesPath + "profilesave.json")
        profileSaveFile.writeText(gson.toJson(Profiles.ITEMS,profileListType))
    }

    fun readProfiles() {
        val profileSaveFile = File(filesPath + "profilesave.json")
        Profiles.ITEMS.addAll(gson.fromJson(profileSaveFile.readText(),profileListType))
    }
}