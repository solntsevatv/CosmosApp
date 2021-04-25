package com.astrateam.spaceexplorer.presentation.ui.viewmodel

import androidx.lifecycle.*
import com.astrateam.database.CompositeRepository
import com.astrateam.database.ModelRepository
import com.astrateam.database.model.Picture
import kotlinx.coroutines.launch
import java.util.*

class StartScreenViewModel : ViewModel() {
    private val repository: ModelRepository = CompositeRepository

    private val _image: MutableLiveData<Picture> = MutableLiveData(null)
    val image: LiveData<Picture>
        get() = _image

    private val _isLoading: MutableLiveData<UiState> = MutableLiveData(UiState.SLEEP)
    val isLoading: LiveData<UiState>
        get() = _isLoading

    init {
        takeImage()
    }

    fun takeImage() {
        viewModelScope.launch {
            runCatching {
                changeUiState()
                val currentDate: Date = Calendar.getInstance().time
                _image.value = repository.getPicture(currentDate)
            }.onFailure {
                changeErrorUiState()
            }
        }
    }

    fun changeUiState() {
        if (_isLoading.value == UiState.SLEEP)
            _isLoading.value = UiState.LOADING
        else
            _isLoading.value = UiState.SLEEP
    }

    fun changeErrorUiState() {
        _isLoading.value = UiState.ERROR
    }

    enum class UiState {
        LOADING,
        ERROR,
        SLEEP
    }
}
