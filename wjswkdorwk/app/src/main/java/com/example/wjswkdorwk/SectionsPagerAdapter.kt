package com.example.digitalphotoframe.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(fa: FragmentActivity, private val imageUris: List<String>) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = imageUris.size

    override fun createFragment(position: Int): Fragment {
        val fragment = PlaceholderFragment()
        fragment.arguments = Bundle().apply {
            putString(PlaceholderFragment.ARG_IMAGE_URI, imageUris[position])
        }
        return fragment
    }
}
