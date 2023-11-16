package com.material.androidpro.compose.ui.data

import com.material.androidpro.R
import com.material.androidpro.model.Owner
import com.material.androidpro.model.Pet

object PetData {
    val owner = Owner("Sophia Evelyn", "Pet Lover", R.drawable.profile_1)
    val petList = listOf(
        Pet(
            0,
            "Charlie",
            6.5,
            "Male",
            "Brown",
            10.0,
            R.drawable.dog_1,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            owner
        ),
        Pet(
            1,
            "Buddy",
            4.5,
            "Male",
            "Gold",
            11.2,
            R.drawable.dog_2,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            owner
        ),
        Pet(
            2,
            "Rocky",
            8.5,
            "Female",
            "White",
            8.4,
            R.drawable.dog_3,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            owner
        ),
        Pet(
            3,
            "Jack",
            5.5,
            "Male",
            "Black",
            7.9,
            R.drawable.dog_4,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            owner
        ),
        Pet(
            4,
            "Oliver",
            3.5,
            "Female",
            "Choco",
            12.6,
            R.drawable.dog_2,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            owner
        )
    )
}
