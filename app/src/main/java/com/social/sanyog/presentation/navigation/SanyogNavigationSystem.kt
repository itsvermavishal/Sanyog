package com.social.sanyog.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.social.sanyog.presentation.callscreen.CallScreen
import com.social.sanyog.presentation.groupsscreen.GroupsScreen
import com.social.sanyog.presentation.homescreen.HomeScreen
import com.social.sanyog.presentation.profile.UserProfileScreen
import com.social.sanyog.presentation.splashscreen.SplashScreen
import com.social.sanyog.presentation.statusscreen.StatusScreen
import com.social.sanyog.presentation.userregistrationscreen.UserRegistrationScreen
import com.social.sanyog.presentation.viewmodel.BaseViewModel
import com.social.sanyog.presentation.welcomescreen.WelcomeScreen

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
            UserRegistrationScreen(navController)
        }

        composable<Routes.HomeScreen>{
            val baseViewModel:BaseViewModel = hiltViewModel()
            HomeScreen(navController, baseViewModel)
        }

        composable<Routes.StatusScreen>{
            StatusScreen(navController)
        }

        composable<Routes.GroupsScreen>{
            GroupsScreen(navController)
        }

        composable<Routes.CallScreen>{
            CallScreen(navController)
        }

        composable<Routes.UserProfileScreen>{
            UserProfileScreen(navHostController = navController)
        }

    }
}
