package com.example.scalable

data class Scale(
    val baseNote: Char,
    val range: Range,
    val majMin: MajMin = MajMin.Major,
    val articulation: Articulation = Articulation.None,
    val seventh: Seventh = Seventh.Base,
    val sharp: Boolean = false,
    val thirds: Boolean = false,
    val chromatic: Boolean = false,
    val arpeggio: Boolean = false
) {
    enum class Range { Oct, Twelfth, TwoOct }
    enum class MajMin { Major, Melodic, Harmonic }
    enum class Articulation { None, Tongued, Slurred }
    enum class Seventh { Base, Dominant, Diminished }
}
