package com.rajpakhurde.notesapp

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.util.Log
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    companion object{
        private const val TAG = "TAG"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(HomeFragment.newInstance(),true)
    }

    fun replaceFragment(fragment: Fragment, isTransition: Boolean){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        if (isTransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.flMain,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }
}