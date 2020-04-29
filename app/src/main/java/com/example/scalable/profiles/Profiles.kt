package com.example.scalable.profiles

import com.example.scalable.Profile
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object Profiles {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<Profile> = mutableListOf()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<Int, Profile> = HashMap()

    private fun addItem(item: Profile) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

}
