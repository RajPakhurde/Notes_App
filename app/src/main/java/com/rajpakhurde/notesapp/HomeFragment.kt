package com.rajpakhurde.notesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rajpakhurde.notesapp.adapter.NoteAdapter
import com.rajpakhurde.notesapp.database.NoteDataBase
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvMain)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        launch {
            context?.let {
                var notes = NoteDataBase.getDataBase(it).noteDao().getAllNote()
                recyclerView.adapter = NoteAdapter(notes)
            }
        }

        val fabAddBtn = view.findViewById<FloatingActionButton>(R.id.fabAdd)
        fabAddBtn.setOnClickListener {
            replaceFragment(CreateNoteFragment.newInstance(),true)
        }
    }

    fun replaceFragment(fragment: Fragment, isTransition: Boolean){
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()
        if (isTransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.flMain,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }
}