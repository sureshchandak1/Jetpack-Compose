package com.material.androidpro.compose.ui.musicStreaming.models

import com.google.firebase.firestore.QueryDocumentSnapshot
import com.material.androidpro.compose.ui.musicStreaming.Constants

data class Track(
    val img: String,
    val songTitle: String,
    val index: Int,
    val artist: String,
    val trackUrl: String,
    var isPlaying: Boolean,
    var fileName: String
)

fun QueryDocumentSnapshot.toTrack(index: Int, imgUrl: String, trackUrl: String): Track {
    return Track(
        img = imgUrl,
        songTitle = this.getString(Constants.NAME) ?: "",
        artist = this.getString(Constants.ARTIST) ?: "",
        fileName = this.getString(Constants.FILENAME) ?: "",
        isPlaying = false,
        index = index,
        trackUrl = trackUrl
    )
}
