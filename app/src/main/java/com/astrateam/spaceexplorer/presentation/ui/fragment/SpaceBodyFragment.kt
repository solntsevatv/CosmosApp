package com.astrateam.spaceexplorer.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.astrateam.spaceexplorer.databinding.FragmentSpaceBodyBinding

// Пример для организации Navigation
class SpaceBodyFragment : Fragment() {

    private lateinit var viewBinding: FragmentSpaceBodyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSpaceBodyBinding.inflate(inflater, container, false)
        return viewBinding.root
    }
}
