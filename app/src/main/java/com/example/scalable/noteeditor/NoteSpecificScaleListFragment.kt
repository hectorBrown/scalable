package com.example.scalable.noteeditor

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.scalable.R
import com.example.scalable.Scale

import com.example.scalable.profiles.Profiles

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [NoteSpecificScaleListFragment.OnListFragmentInteractionListener] interface.
 */
class NoteSpecificScaleListFragment : Fragment() {

    // TODO: Customize parameters
    private var baseNote: String? = null
    private var columnCount: Int = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            baseNote = it.getString(ARG_BASENOTE)
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.fragment_note_specific_scale_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                //select scales based on note
                val noteBasedScaleList: List<Scale> = Profiles.CurrProf?.content!!.filter { s: Scale -> s.baseNote.toString() == baseNote }
                adapter = MyNoteSpecificScaleListRecyclerViewAdapter(noteBasedScaleList, listener)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: Scale?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_BASENOTE = "base-note"
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(baseNote: String, columnCount: Int) =
            NoteSpecificScaleListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_BASENOTE, baseNote)
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
