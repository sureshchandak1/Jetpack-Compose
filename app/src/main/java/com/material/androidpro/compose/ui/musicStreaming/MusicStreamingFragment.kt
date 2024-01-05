package com.material.androidpro.compose.ui.musicStreaming

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.material.androidpro.R
import com.material.androidpro.compose.ui.musicStreaming.models.MusicPlayerOption
import com.material.androidpro.compose.ui.musicStreaming.models.Track
import com.material.androidpro.compose.ui.musicStreaming.ui.composables.LoadingScreen
import com.material.androidpro.compose.ui.musicStreaming.ui.composables.Player
import com.material.androidpro.compose.ui.musicStreaming.ui.composables.Title
import com.material.androidpro.compose.ui.musicStreaming.ui.composables.TrackDetailDialog
import com.material.androidpro.compose.ui.musicStreaming.ui.composables.TrackList
import com.material.androidpro.compose.ui.musicStreaming.ui.composables.TurnTable
import com.material.androidpro.compose.ui.musicStreaming.ui.theme.MusicStreamingTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MusicStreamingFragment : Fragment(), OnMusicButtonClick {

    private val isPlaying = mutableStateOf(false) // is music current being played
    private var trackList = listOf<Track>() // retrieve song list
    private lateinit var currentSong: MutableState<Track>// currently playing song
    private val clickedSong: MutableState<Track?> = mutableStateOf(null)// currently playing song
    private val currentSongIndex = mutableStateOf(-1) // used for recyclerview playing overlay
    private val turntableArmState = mutableStateOf(false)// turns turntable arm
    private val isBuffering = mutableStateOf(false)
    private val isTurntableArmFinished =
        mutableStateOf(false) // lets us know the turntable Arm rotation is finished
    private lateinit var listState: LazyListState // current state of album list
    private lateinit var coroutineScope: CoroutineScope // scope to be used in composables
    private lateinit var mediaPlayer: MediaPlayer
    private val viewModel: MusicStreamingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            observeViewModel()
            setContent {
                MusicStreamingTheme {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        listState = rememberLazyListState()
                        coroutineScope = rememberCoroutineScope()
                        val openDialog = remember { mutableStateOf(false) }
                        val trackList by viewModel.trackList.observeAsState()
                        if (trackList?.isNotEmpty() == true) {
                            MainContent(
                                isPlaying = isPlaying,
                                currentSong,
                                listState,
                                onMusicPlayerClick = this@MusicStreamingFragment,
                                currentSongIndex,
                                turntableArmState,
                                isTurntableArmFinished,
                                isBuffering = isBuffering,
                                trackList!!
                            ) { song ->
                                clickedSong.value = song
                                openDialog.value = true
                            }
                            TrackDetailDialog(trackMutableState = clickedSong, openDialog = openDialog)
                        } else {
                            LoadingScreen()
                        }
                    }
                }
            }
        }
    }

    private fun observeViewModel() {
        viewModel.trackList.observe(viewLifecycleOwner) { list ->
            if (list.isNotEmpty()) {
                trackList = list
                currentSong = mutableStateOf(list.first())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::mediaPlayer.isInitialized && isPlaying.value) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }

    private fun play() {
        try {
            if (this::mediaPlayer.isInitialized && isPlaying.value) {
                mediaPlayer.stop()
                mediaPlayer.release()
                isPlaying.value = false
                turntableArmState.value = false
                isTurntableArmFinished.value = false
            }
            isBuffering.value = true
            mediaPlayer = MediaPlayer()
            mediaPlayer.setDataSource(currentSong.value.trackUrl)
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener {
                isBuffering.value = false
                isPlaying.value = true
                if (!turntableArmState.value) {
                    turntableArmState.value = true
                }
                mediaPlayer.start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun updateList() {
        coroutineScope.launch {
            if (isPlaying.value) {
                currentSong.value.isPlaying = true
            }
            listState.animateScrollToItem(
                currentSong.value.index
            )
        }
    }

    override fun onMusicButtonClick(command: MusicPlayerOption) {
        when (command) {
            MusicPlayerOption.Skip -> {
                // check list
                var nextSongIndex = currentSong.value.index + 1 // increment next
                // if current song is last song in the tracklist (track list starts at 0)
                if (currentSong.value.index == trackList.size - 1) {
                    nextSongIndex = 0 // go back to first song
                    if (isPlaying.value) {
                        currentSongIndex.value = 0 // playing song is first song in list
                    }
                } else {
                    currentSongIndex.value++ // increment song index
                }
                currentSong.value = trackList[nextSongIndex]

                if (isPlaying.value) {
                    play()
                }
                updateList()
            }
            MusicPlayerOption.Previous -> {

                var previousSongIndex = currentSong.value.index - 1 // increment previous
                // if current song is first song in the tracklist (track list starts at 0)
                if (currentSong.value.index == 0) {
                    previousSongIndex = trackList.lastIndex // go to last song in list
                    if (isPlaying.value) {
                        currentSongIndex.value =
                            trackList.lastIndex // last song is now playing song
                    }
                } else {
                    currentSongIndex.value-- // decrement current song
                }
                currentSong.value = trackList[previousSongIndex]

                if (isPlaying.value) {
                    play()
                }

                updateList()
            }

            MusicPlayerOption.Play -> {
                currentSong.value.isPlaying =
                    !isPlaying.value // confirms whether current song is played or paused
                currentSongIndex.value = currentSong.value.index //confirms current song Index
                try {
                    if (this::mediaPlayer.isInitialized && isPlaying.value) {
                        mediaPlayer.stop()
                        mediaPlayer.release()
                        isPlaying.value = false
                    } else play()
                } catch (e: Exception) {
                    mediaPlayer.release()
                    isPlaying.value = false
                }
            }
        }

    }

}

@Composable
fun MainContent(
    isPlaying: MutableState<Boolean>,
    album: MutableState<Track>,
    listState: LazyListState,
    onMusicPlayerClick: OnMusicButtonClick,
    currentSongIndex: MutableState<Int>,
    turntableArmState: MutableState<Boolean>,
    isTurntableArmFinished: MutableState<Boolean>,
    isBuffering: MutableState<Boolean>,
    albums: List<Track>,
    onTrackItemClick: (Track) -> Unit,
) {
    Column {
        Title()
        TrackList(
            isPlaying,
            listState,
            currentSongIndex,
            R.drawable.ic_baseline_pause_24,
            albums,
            onTrackItemClick
        )
        TurnTable(isPlaying, turntableArmState, isTurntableArmFinished)
        Player(
            album, isPlaying,
            onMusicPlayerClick = onMusicPlayerClick,
            isTurntableArmFinished = isTurntableArmFinished,
            isBuffering = isBuffering
        )
    }
}

interface OnMusicButtonClick {
    fun onMusicButtonClick(command: MusicPlayerOption)
}