package com.example.scalable

import android.widget.TextView
import kotlin.coroutines.coroutineContext

class Scale(
    val baseNote: Char,
    val range: Range,
    val majMin: MajMin = MajMin.Major,
    val articulation: Articulation = Articulation.None,
    val sharp: Boolean = false,
    val type: Type = Type.Scale
) {
    enum class Range { Oct, Twelfth, TwoOct }
    enum class MajMin { Major, Melodic, Harmonic }
    enum class Articulation { None, Tongued, Slurred }
    enum class Seventh { Base, Dominant, Diminished }
    enum class Type { Scale, Arpeggio, Chromatic, Thirds, DominantSeventh, DiminishedSeventh }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        with (stringBuilder) {
            append(when (type) {
                Type.Arpeggio -> "Arpeggio: "
                Type.Chromatic -> "Chromatic: "
                Type.Thirds -> "In thirds: "
                Type.DominantSeventh -> "Dominant seventh: "
                Type.DiminishedSeventh -> "Diminished seventh: "
                else -> ""
            })
            append(baseNote + when(sharp) {true -> "#" else -> "" } + " ")
            append(when (majMin) {
                MajMin.Major -> "major "
                MajMin.Melodic -> "minor melodic "
                MajMin.Harmonic -> "minor harmonic "
            })
            append("for " + when(range) {
                Range.Oct -> "1 octave "
                Range.Twelfth -> "a twelfth "
                Range.TwoOct -> "2 octaves "
            })
            append(when(articulation) {
                Articulation.Slurred -> "slurred"
                Articulation.Tongued -> "tongued"
                Articulation.None -> ""
            })

        }
        return stringBuilder.toString()
    }
}
