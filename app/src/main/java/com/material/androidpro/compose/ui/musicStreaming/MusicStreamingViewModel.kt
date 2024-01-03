package com.material.androidpro.compose.ui.musicStreaming

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.material.androidpro.compose.ui.musicStreaming.models.Track
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicStreamingViewModel @Inject constructor(repository: MusicStreamingRepository) : ViewModel() {

    private val _trackList = MutableLiveData<List<Track>>()
    val trackList : LiveData<List<Track>> get() = _trackList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getTracks().let { trackList ->
                _trackList.postValue(trackList.sortedBy { it.index })
            }
        }
    }

}