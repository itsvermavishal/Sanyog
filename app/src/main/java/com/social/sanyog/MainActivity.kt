package com.social.sanyog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.social.sanyog.presentation.navigation.SanyogNavigationSystem
import com.social.sanyog.ui.theme.SanyogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SanyogTheme {

                SanyogNavigationSystem()
            }
        }
    }
}