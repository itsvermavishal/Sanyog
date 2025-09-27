package com.social.sanyog

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SanyogApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        // This line ensures Firebase initializes correctly
        FirebaseApp.initializeApp(this)
    }
}