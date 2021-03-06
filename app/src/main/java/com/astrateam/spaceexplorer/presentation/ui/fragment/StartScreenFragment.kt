package com.astrateam.spaceexplorer.presentation.ui.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.astrateam.spaceexplorer.databinding.StartScreenFragmentBinding
import com.astrateam.spaceexplorer.presentation.ui.viewmodel.StartScreenViewModel
import com.bumptech.glide.Glide

class StartScreenFragment : Fragment() {
    private lateinit var viewBinding: StartScreenFragmentBinding
    private val viewModel: StartScreenViewModel by viewModels()

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

        viewBinding.reloadButton.setOnClickListener {
            viewModel.takeImage()
        }

        viewModel.image.observe(viewLifecycleOwner, { picture ->
            picture?.let {
                loadImage(picture.uri)
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, { state ->
            changeVisibilityItems(state)
        })
    }

    private fun loadImage(uri: Uri) {
        runCatching {
            Glide.with(requireContext()).load(uri).into(viewBinding.spaceImage)
            if (viewModel.isLoading.value != StartScreenViewModel.UiState.SLEEP)
                viewModel.changeUiState()
        }.onFailure {
            viewModel.changeErrorUiState()
        }
    }

    private fun changeVisibilityItems(state: StartScreenViewModel.UiState) {
        when (state) {
            StartScreenViewModel.UiState.LOADING -> {
                viewBinding.spaceImage.visibility = View.INVISIBLE
                viewBinding.progressImage.visibility = View.VISIBLE
                viewBinding.errorLoadImage.visibility = View.INVISIBLE
                viewBinding.reloadButton.visibility = View.INVISIBLE
            }
            StartScreenViewModel.UiState.ERROR -> {
                viewBinding.spaceImage.visibility = View.INVISIBLE
                viewBinding.progressImage.visibility = View.INVISIBLE
                viewBinding.errorLoadImage.visibility = View.VISIBLE
                viewBinding.reloadButton.visibility = View.VISIBLE
            }
            else -> {
                viewBinding.spaceImage.visibility = View.VISIBLE
                viewBinding.progressImage.visibility = View.INVISIBLE
            }
        }
    }
}
