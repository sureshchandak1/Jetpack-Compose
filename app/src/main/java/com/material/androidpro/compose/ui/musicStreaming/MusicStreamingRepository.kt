package com.material.androidpro.compose.ui.musicStreaming

import android.text.TextUtils
import com.google.firebase.firestore.QuerySnapshot
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

                val trackResult: QuerySnapshot = task.result

                trackResult.forEach { document ->
                    val imageUrlPath: String = document.getString(Constants.ALBUM_ART) ?: ""
                    val trackUrlPath: String = document.getString(Constants.FILENAME) ?: ""

                    if (!TextUtils.isEmpty(imageUrlPath) && !TextUtils.isEmpty(trackUrlPath)) {

                        val imageUrl = albumArt.child(imageUrlPath)
                        val trackUrl = trackRef.child(trackUrlPath)

                        imageUrl.downloadUrl.addOnSuccessListener {  imageDownloadUrl ->
                            trackUrl.downloadUrl.addOnSuccessListener { trackDownloadUrl ->
                                trackList.add(
                                    document.toTrack(
                                        index = index,
                                        imgUrl = imageDownloadUrl.toString(),
                                        trackUrl = trackDownloadUrl.toString()
                                    )
                                )
                                if (index == trackResult.size() - 1) {
                                    result.resume(trackList)
                                }
                                index++
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            ExceptionHelper.printStackTrace(e)
        }
    }

}