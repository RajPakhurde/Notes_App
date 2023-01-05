package com.rajpakhurde.notesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class CreateNoteFragment : Fragment() {

    val etTitle = view?.findViewById<TextView>(R.id.etTitle)
    val etSubTitle = view?.findViewById<TextView>(R.id.etSubTitle)
    val etNoteDesc = view?.findViewById<TextView>(R.id.etNoteDesc)

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
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CreateNoteFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvDateTime = view.findViewById<TextView>(R.id.tvDateTime)
        val ivBackBtn = view.findViewById<ImageView>(R.id.ivBackBtn)
        val ivSaveBtn = view.findViewById<ImageView>(R.id.ivSaveBtn)


        val sdf = SimpleDateFormat("dd/M/yyyy mm:HH:ss")
        val currentDate = sdf.format(Date())
        tvDateTime.text = currentDate

        ivSaveBtn.setOnClickListener {
            saveNotes()
        }

        ivBackBtn.setOnClickListener {
            replaceFragment(HomeFragment.newInstance(),true)
        }

    }

    fun replaceFragment(fragment: Fragment, isTransition: Boolean){
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()
        if (isTransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
        }
        fragmentTransition.replace(R.id.flMain,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }

    private fun saveNotes() {

        if (etTitle?.text.isNullOrEmpty()){
            Toast.makeText(context,"Note Title is Required.",Toast.LENGTH_SHORT).show()
        }
        if (etSubTitle?.text.isNullOrEmpty()){
            Toast.makeText(context,"Note Sub Title is Required.",Toast.LENGTH_SHORT).show()
        }
        if (etNoteDesc?.text.isNullOrEmpty()){
            Toast.makeText(context,"Note Description is Required.",Toast.LENGTH_SHORT).show()
        }
    }
}