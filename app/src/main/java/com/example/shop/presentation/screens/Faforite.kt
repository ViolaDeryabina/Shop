package com.example.shop.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.presentation.components.BottomBar
import com.example.shop.presentation.components.CustomCard
import com.example.shop.presentation.components.ScreenHeader
import com.example.shop.presentation.logDebug
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.navigation.Catalog
import com.example.shop.presentation.navigation.Details
import com.example.shop.presentation.navigation.Home
import com.example.shop.presentation.navigation.MyCart
import com.example.shop.presentation.navigation.Notification
import com.example.shop.presentation.navigation.Popular
import com.example.shop.presentation.navigation.Profile
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание экрана фавориты
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun Favorite(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    val scroll = rememberScrollState()
    logInfo("Favorite","Создание экрана","Отрисовка экрана Избранное")

    Scaffold(
        topBar = {
            Spacer(modifier = Modifier.height(12.dp))
            ScreenHeader(
                title = "Избранное",
                onBackClick = {
                    logDebug("Favorite","Нажатие на кнопку","Переход назад по стэку")
                    navController.popBackStack()
                },
                modifier = Modifier.padding(horizontal = 20.dp),
                icon = {
                    IconButton(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(CustomTheme.colors.block)
                            .size(40.dp), onClick = {
                            logDebug("Favorite","Нажатие на кнопку","Переход на экран Catalog")
                            navController.navigate(Catalog)
                        }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.path),
                            contentDescription = "",
                            tint = CustomTheme.colors.red,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomBar(
                selectedInt = 0,
                homeOnClick = { },
                favoriteOnClick = {
                    logDebug("Favorite","Нажатие на кнопку","Переход на экран favoriteOnClick")
                    navController.navigate(Popular)
                },
                notificationOnClick = {
                    logDebug("Favorite", "Нажатие кнопки", "Переход на экран Notification")
                    navController.navigate(Notification)
                },
                profileOnClick = {
                    logDebug("Favorite", "Нажатие кнопки", "Переход на экран Profile")
                    navController.navigate(Profile)
                },
                basketOnClick = {
                    logDebug("Favorite","Нажатие на кнопку","Переход на экран MyCart")
                    navController.navigate(MyCart)
                }
            )
        },
        containerColor = CustomTheme.colors.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(scroll)
                .padding(start = 20.dp)
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomCard(
                    modifier = Modifier
                        .weight(0.42f)
                        .clickable(onClick = {
                            navController.navigate(
                                Details
                            )
                        }),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true,
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.add),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .size(30.dp)
                                .offset(y = (2).dp)
                        )
                    }

                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true,
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.add),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .size(30.dp)
                                .offset(y = (2).dp)
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true,
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.add),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .size(30.dp)
                                .offset(y = (2).dp)
                        )
                    }
                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true,
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.add),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .size(30.dp)
                                .offset(y = (2).dp)
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true,
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.add),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .size(30.dp)
                                .offset(y = (2).dp)
                        )
                    }
                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true,
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.add),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .size(30.dp)
                                .offset(y = (2).dp)
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true,
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.add),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .size(30.dp)
                                .offset(y = (2).dp)
                        )
                    }
                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true,
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.add),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .size(30.dp)
                                .offset(y = (2).dp)
                        )
                    }
                )
            }
        }
    }
}


@Preview
@Composable
private fun PopularPrev() {
    CustomTheme {
        Favorite()
    }
}