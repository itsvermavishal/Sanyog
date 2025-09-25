package com.example.sanyog.presentation.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sanyog.R
import com.example.sanyog.presentation.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController){

    LaunchedEffect(Unit) {

        delay(1000)

        navHostController.navigate(Routes.WelcomeScreen){

            popUpTo(Routes.SplashScreen){inclusive = true}
        }
    }

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.sanyog_icon),
            contentDescription = "Logo",
            modifier = Modifier.size(80.dp)
                .align(Alignment.Center)
        )

        Column(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Sanyog", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Crafted with 💛",
                fontSize = 14.sp
            )
        }
    }
}