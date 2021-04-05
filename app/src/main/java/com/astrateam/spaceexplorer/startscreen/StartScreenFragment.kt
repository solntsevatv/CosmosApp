package com.astrateam.spaceexplorer.startscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.astrateam.spaceexplorer.databinding.StartScreenFragmentBinding

class StartScreenFragment : Fragment() {
    private lateinit var viewBinding: StartScreenFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = StartScreenFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

//  Получение от NetworkService изображения звездного неба
    fun takeSpaceImage(){

    }
}