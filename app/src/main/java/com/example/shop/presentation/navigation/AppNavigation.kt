package com.example.shop.presentation.navigation

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shop.presentation.screens.Catalog
import com.example.shop.presentation.screens.CheckoutEmpty
import com.example.shop.presentation.screens.Details
import com.example.shop.presentation.screens.Favorite
import com.example.shop.presentation.screens.ForgotPassword
import com.example.shop.presentation.screens.Home
import com.example.shop.presentation.screens.Map
import com.example.shop.presentation.screens.MyCart
import com.example.shop.presentation.screens.Onboard
import com.example.shop.presentation.screens.Popular
import com.example.shop.presentation.screens.RegisterAccount
import com.example.shop.presentation.screens.Search
import com.example.shop.presentation.screens.SignIn

//Назначение: Навигация между экранами
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(navController = navController, startDestination = Onboard) {
            composable<RegisterAccount> {
                Log.d("AppNavigation", "Переход на экран RegisterAccount")
                RegisterAccount(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<Onboard> {
                Log.d("AppNavigation", "Переход на экран Onboard")
                Onboard(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<SignIn> {
                Log.d("AppNavigation", "Переход на экран SignIn")
                SignIn(navController = navController)
            }
            composable<Home> {
                Log.d("AppNavigation", "Переход на экран Home")
                Home(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<Popular> {
                Log.d("AppNavigation", "Переход на экран Popular")
                Popular(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<Catalog> {
                Log.d("AppNavigation", "Переход на экран Catalog")
                Catalog(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<Favorite> {
                Log.d("AppNavigation", "Переход на экран Favorite")
                Favorite(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<MyCart> {
                Log.d("AppNavigation", "Переход на экран MyCart")
                MyCart(
                    modifier = Modifier.padding(innerPadding),

                    )
            }
            composable<Details> {
                Log.d("AppNavigation", "Переход на экран Details")
                Details(
                    modifier = Modifier.padding(innerPadding),
                    //navController
                )
            }
            composable<Search> {
                Log.d("AppNavigation", "Переход на экран ForgotPassword")
                Search(
                    modifier = Modifier.padding(innerPadding), navController
                )//ForgotPassword

            }
            composable<ForgotPassword> {
                Log.d("AppNavigation", "Переход на экран ForgotPassword")
                ForgotPassword(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
            composable<Map> {
                Log.d("AppNavigation", "Переход на экран Map")
                Map(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
            composable<CheckoutEmpty> {
                Log.d("AppNavigation", "Переход на экран CheckoutEmpty")
                CheckoutEmpty(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
        }
    }
}