package com.example.sanyog.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sanyog.presentation.callscreen.CallScreen
import com.example.sanyog.presentation.groupsscreen.GroupsScreen
import com.example.sanyog.presentation.homescreen.HomeScreen
import com.example.sanyog.presentation.splashscreen.SplashScreen
import com.example.sanyog.presentation.statusscreen.StatusScreen
import com.example.sanyog.presentation.userregistrationscreen.UserRegistrationScreen
import com.example.sanyog.presentation.welcomescreen.WelcomeScreen

@Composable
fun SanyogNavigationSystem(){

    val navController = rememberNavController()

    NavHost(startDestination = Routes.SplashScreen, navController = navController){

        composable<Routes.SplashScreen>{
            SplashScreen(navController)
        }

        composable<Routes.WelcomeScreen>{
            WelcomeScreen(navController)
        }

        composable<Routes.UserRegistrationScreen>{
            UserRegistrationScreen()
        }

        composable<Routes.HomeScreen>{
            HomeScreen()
        }

        composable<Routes.StatusScreen>{
            StatusScreen()
        }

        composable<Routes.GroupsScreen>{
            GroupsScreen()
        }

        composable<Routes.CallScreen>{
            CallScreen()
        }

    }
}
