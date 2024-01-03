package com.material.androidpro.compose.ui.musicStreaming

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.material.androidpro.compose.ui.musicStreaming.models.Track
import com.material.androidpro.compose.ui.musicStreaming.models.toTrack
import com.material.androidpro.utils.helpers.ExceptionHelper
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MusicStreamingRepository {
    private val storage = Firebase.storage
    private val albumArt: StorageReference = storage.reference.child(Constants.ALBUM_ART_CAPS)
    private val trackRef: StorageReference = storage.reference

    suspend fun getTracks() = suspendCoroutine<List<Track>> { result ->
        val trackList = mutableListOf<Track>()

        try {
            Firebase.firestore.collection(Constants.TRACKS).get().addOnCompleteListener { task ->
                var index = 0

                task.result.forEach { document ->
                    val imageUrl: StorageReference = albumArt.child(document.getString(Constants.ALBUM_ART) ?: "")
                    val trackUrl: StorageReference = trackRef.child(document.getString(Constants.FILENAME) ?: "")

                    imageUrl.downloadUrl.addOnSuccessListener {  imageDownloadUrl ->
                        trackUrl.downloadUrl.addOnSuccessListener { trackDownloadUrl ->
                            trackList.add(
                                document.toTrack(
                                    index = index,
                                    imgUrl = imageDownloadUrl.toString(),
                                    trackUrl = trackDownloadUrl.toString()
                                )
                            )
                            if (index == task.result.size() - 1) {
                                result.resume(trackList)
                            }
                            index++
                        }
                    }
                }
            }
        } catch (e: Exception) {
            ExceptionHelper.printStackTrace(e)
        }
    }

}