package com.astrateam.spaceexplorer.startscreen

import android.accounts.NetworkErrorException
import androidx.lifecycle.*
import com.astrateam.spaceexplorer.domain.IUserRepository
import com.astrateam.spaceexplorer.stubs.StubUserRepository
import kotlinx.coroutines.launch
import java.io.IOError
import java.io.IOException

class StartScreenViewModel : ViewModel() {
    private val repository: IUserRepository = StubUserRepository()

    private val _image: MutableLiveData<String> = MutableLiveData(null)
    val image: LiveData<String>
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
                _image.value = repository.loadTodayImage()
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
