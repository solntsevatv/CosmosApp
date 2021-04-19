package com.astrateam.spaceexplorer.startscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.astrateam.spaceexplorer.databinding.StartScreenFragmentBinding

class StartScreenFragment : Fragment() {
    private lateinit var viewBinding: StartScreenFragmentBinding
    private lateinit var viewModel: StartScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = StartScreenFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(StartScreenViewModel::class.java)
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
    }
}