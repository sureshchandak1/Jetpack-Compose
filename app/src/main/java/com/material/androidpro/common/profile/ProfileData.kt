package com.material.androidpro.common.profile

import com.material.androidpro.R

class ProfileData private constructor() {

    init {
        throw IllegalArgumentException(ProfileData::class.java.name)
    }

    companion object {

        fun profileList(): List<Profile> {

            val profileList: MutableList<Profile> = ArrayList()

            profileList.add(
                Profile(R.drawable.profile_1, "Aadhavi")
            )
            profileList.add(
                Profile(R.drawable.profile_3, "Divya")
            )
            profileList.add(
                Profile(
                    R.drawable.profile_4, "Jivika"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_5, "Kavya"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_6, "Sarika"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_7, "Lavanya"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_9, "Uma"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_10, "Emma"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_11, "Sophia"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_12, "Evelyn"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_13, "Camila"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_14, "Scarlett"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_15, "Penelope"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_16, "Madison"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_17, "Madison"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_18, "Benjamin"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_19, "Theodore"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_20, "Jack"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_21, "Logan"
                )
            )
            profileList.add(
                Profile(
                    R.drawable.profile_22, "Joseph"
                )
            )

            return profileList
        }
    }
}