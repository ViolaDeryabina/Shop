package com.example.shop.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shop.presentation.navigation.RegisterAccount

import com.example.shop.presentation.navigation.SignIn
import com.example.shop.presentation.screens.Onboard
import com.example.shop.presentation.screens.RegisterAccount
import com.example.shop.presentation.screens.SignIn

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(navController = navController, startDestination = Onboard) {

            composable<RegisterAccount> {
                RegisterAccount(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }

            composable<Onboard> {
                Onboard(
                    modifier = Modifier.padding(innerPadding),
                    //navController
                )
            }
            composable<SignIn> { SignIn() }

        }
    }

}