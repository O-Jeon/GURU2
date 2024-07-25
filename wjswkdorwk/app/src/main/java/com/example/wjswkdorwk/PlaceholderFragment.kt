package com.example.digitalphotoframe.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.digitalphotoframe.R
import kotlinx.android.synthetic.main.fragment_main.*

class PlaceholderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(ARG_IMAGE_URI)?.let { imageUri ->
            Glide.with(this).load(imageUri).into(imageView)
        }
    }

    companion object {
        const val ARG_IMAGE_URI = "image_uri"
    }
}
