package com.material.newsapp.domain.usecases.appentry

import com.material.newsapp.domain.manger.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke() {
        localUserManger.saveAppEntry()
    }

}