package com.material.androidpro.model.petlist

import androidx.compose.runtime.Immutable
import java.util.UUID

@Immutable
data class Pet(
    val id: Int,
    val name: String,
    val age: Double,
    val gender: String,
    val color: String,
    val weight: Double,
    val image: Int,
    val about: String,
    val owner: Owner,
    val uniqueId: String = UUID.randomUUID().toString(),
)
