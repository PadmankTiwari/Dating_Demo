package com.example.aisle

import android.app.Application
import com.example.aisle.data.session.SessionManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class Aisle : Application() {

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate() {
        super.onCreate()
        setSessionManager(sessionManager)
    }

    companion object {
        private lateinit var mSessionManager: SessionManager

        fun setSessionManager(sessionManager: SessionManager) {
            mSessionManager = sessionManager
        }
    }
}