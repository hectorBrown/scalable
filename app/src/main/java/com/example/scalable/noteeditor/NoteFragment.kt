package com.example.scalable.noteeditor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.scalable.R
import com.example.scalable.menu.MenuContent


/**
 * A simple [Fragment] subclass.
 * Use the [NoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
/**
 * This class is loaded dynamically by the tab manager
 * It contains the navhost fragment so that it can dynamically load lists
 */
class NoteFragment : Fragment() {
    private var baseNote: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            baseNote = it.getString("ARG_BASENOTE")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MenuContent.CurrNote = baseNote
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NoteFragment.
         */
        @JvmStatic
        fun newInstance(baseNote: String) =
            NoteFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_BASENOTE", baseNote)
                }
            }
    }
}
