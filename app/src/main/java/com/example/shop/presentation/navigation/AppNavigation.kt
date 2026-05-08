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
import com.example.shop.presentation.logDebug
import com.example.shop.presentation.screens.Catalog
import com.example.shop.presentation.screens.CheckoutEmpty
import com.example.shop.presentation.screens.DetailOrder
import com.example.shop.presentation.screens.Details
import com.example.shop.presentation.screens.Favorite
import com.example.shop.presentation.screens.ForgotPassword
import com.example.shop.presentation.screens.Home
import com.example.shop.presentation.screens.LoyaltyCard
import com.example.shop.presentation.screens.Map
import com.example.shop.presentation.screens.MyCart
import com.example.shop.presentation.screens.Notification
import com.example.shop.presentation.screens.Onboard
import com.example.shop.presentation.screens.Orders
import com.example.shop.presentation.screens.Popular
import com.example.shop.presentation.screens.Profile
import com.example.shop.presentation.screens.RegisterAccount
import com.example.shop.presentation.screens.Search
import com.example.shop.presentation.screens.SignIn
import com.example.shop.presentation.screens.Verification

//Назначение: Навигация между экранами
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(navController = navController, startDestination = Onboard) {
            composable<RegisterAccount> {
                logDebug("AppNavigation", "Переход", "Экран RegisterAccount")
                RegisterAccount(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<Onboard> {
                logDebug("AppNavigation", "Переход", "Экран Onboard")
                Onboard(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<SignIn> {
                logDebug("AppNavigation", "Переход", "Экран SignIn")
                SignIn(navController = navController)
            }
            composable<Home> {
                logDebug("AppNavigation", "Переход", "Экран Home")
                Home(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<Popular> {
                logDebug("AppNavigation", "Переход", "Экран Popular")
                Popular(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<Catalog> {
                logDebug("AppNavigation", "Переход", "Экран Catalog")
                Catalog(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<Favorite> {
                logDebug("AppNavigation", "Переход", "Экран Favorite")
                Favorite(
                    modifier = Modifier.padding(innerPadding),
                    navController
                )
            }
            composable<MyCart> {
                logDebug("AppNavigation", "Переход", "Экран MyCart")
                MyCart(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
            composable<Details> {
                logDebug("AppNavigation", "Переход", "Экран Details")
                Details(
                    modifier = Modifier.padding(innerPadding),
                    //navController
                )
            }
            composable<Search> {
                logDebug("AppNavigation", "Переход", "Экран ForgotPassword")
                Search(
                    modifier = Modifier.padding(innerPadding), navController
                )

            }
            composable<ForgotPassword> {
                logDebug("AppNavigation", "Переход", "Экран ForgotPassword")
                ForgotPassword(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
            composable<Map> {
                logDebug("AppNavigation", "Переход", "Экран Map")
                Map(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
            composable<CheckoutEmpty> {
                logDebug("AppNavigation", "Переход", "Экран CheckoutEmpty")
                CheckoutEmpty(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
            composable<Verification> {
                logDebug("AppNavigation", "Переход", "Экран Verification")
                Verification(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
            composable<Profile> {
                logDebug("AppNavigation", "Переход", "Экран Profile")
                Profile(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
            composable<Notification> {
                logDebug("AppNavigation", "Переход", "Экран Notification")
                Notification(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
            composable<LoyaltyCard> {
                logDebug("AppNavigation", "Переход", "Экран LoyaltyCard")
                LoyaltyCard(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }//DetailOrder
            composable<DetailOrder> {
                logDebug("AppNavigation", "Переход", "Экран DetailOrder")
                DetailOrder(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
            composable<Orders> {
                logDebug("AppNavigation", "Переход", "Экран Orders")
                Orders(
                    modifier = Modifier.padding(innerPadding), navController
                )
            }
        }
    }
}