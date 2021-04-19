package com.astrateam.spaceexplorer.startscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astrateam.spaceexplorer.domain.IUserRepository
import com.astrateam.spaceexplorer.stubs.StubUserRepository
import kotlinx.coroutines.launch

class StartScreenViewModel : ViewModel() {
    private val repository: IUserRepository = StubUserRepository()

    private val _image: MutableLiveData<String> = MutableLiveData(null)
    val image: LiveData<String>
        get() = _image

    init {
        viewModelScope.launch {
            _image.value = repository.loadTodayImage()
        }
    }
}