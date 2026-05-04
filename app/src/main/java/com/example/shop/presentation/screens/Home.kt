package com.example.shop.presentation.screens

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.presentation.components.BottomBar
import com.example.shop.presentation.components.CustomCard
import com.example.shop.presentation.components.Input
import com.example.shop.presentation.components.ListCategory
import com.example.shop.presentation.components.Search
import com.example.shop.presentation.navigation.Details
import com.example.shop.presentation.navigation.Favorite
import com.example.shop.presentation.navigation.MyCart
import com.example.shop.presentation.navigation.Popular
import com.example.shop.presentation.navigation.Search
import com.example.shop.presentation.theme.CustomTheme


//Назначение: Создание главного экрана home
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun Home(modifier: Modifier = Modifier, navController: NavController) {
    val scroll = rememberScrollState()
    Scaffold(bottomBar = {
        BottomBar(
            selectedInt = 0,
            homeOnClick = { },
            favoriteOnClick = {
                Log.d("Home", "Нажатие на кнопку favorite для перехода на форму Favorite")
                navController.navigate(Favorite)
            },
            notificationOnClick = { },
            profileOnClick = { },
            basketOnClick = { navController.navigate(MyCart) }
        )
    }) { innerPadding ->
        var search by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(CustomTheme.colors.background)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(scroll)
                    .padding(start = 20.dp)
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(CustomTheme.colors.background)
            ) {
                Spacer(modifier = Modifier.height(3.dp))
                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        modifier = Modifier
                            .size(40.dp), onClick = {}
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.clock_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                        )
                    }
                    Text(
                        text = "Главная",
                        style = CustomTheme.typography.HeadingRegular32,
                        color = CustomTheme.colors.text
                    )

                    Box(contentAlignment = Alignment.TopEnd) {
                        IconButton(
                            modifier = Modifier
                                .clip(shape = CircleShape)
                                .background(CustomTheme.colors.block)
                                .size(40.dp), onClick = {}
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.bag_2),
                                contentDescription = "",
                                tint = CustomTheme.colors.text,
                                modifier = Modifier
                                    .size(30.dp)
                                    .offset(y = (2).dp)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .offset(x = (-5).dp)
                                .background(
                                    CustomTheme.colors.red,
                                    CircleShape
                                )
                        )
                    }

                }
                Spacer(modifier = Modifier.height(21.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Search(
                        value = search,
                        onValueChange = { search = it },
                        modifier = Modifier.clickable(onClick = {
                            navController.navigate(
                                Search
                            )
                        }),
                        placeholder = {
                            Text(
                                text = "Поиск",
                                style = CustomTheme.typography.BodyRegular12,
                                color = CustomTheme.colors.hint
                            )
                        })
                    IconButton(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(CustomTheme.colors.block)
                            .size(52.dp)
                            .background(CustomTheme.colors.accent),
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.sliders),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .size(30.dp)
                                .offset(y = (2).dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(23.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Категории",
                        style = CustomTheme.typography.BodyRegular16,
                        color = CustomTheme.colors.text
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                ListCategory(
                    list = listOf(
                        "Все", "Outdoor", "Tennis"
                    ),
                    onClick = {}
                )
                Spacer(modifier = Modifier.height(23.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Популярное",
                        style = CustomTheme.typography.BodyRegular16,
                        color = CustomTheme.colors.text
                    )
                    Text(
                        text = "Все",
                        style = CustomTheme.typography.BodyRegular12,
                        color = CustomTheme.colors.accent
                    )
                }
                Spacer(modifier = Modifier.height(34.dp))
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

                        )
                    Spacer(modifier = Modifier.width(15.dp))
                    CustomCard(
                        modifier = Modifier.weight(0.42f),
                        bitmap = ImageBitmap.imageResource(R.drawable.bot),
                        title = "Nike Air Max",
                        category = "Best Seller",
                        price = 752
                    )
                }
                Spacer(modifier = Modifier.height(29.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Акции",
                        style = CustomTheme.typography.BodyRegular16,
                        color = CustomTheme.colors.text
                    )
                    Text(
                        text = "Все",
                        style = CustomTheme.typography.BodyRegular12,
                        color = CustomTheme.colors.accent
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    bitmap = ImageBitmap.imageResource(R.drawable.frame_1000000849),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

        }
    }

}

@Preview
@Composable
private fun HomePrev() {
    CustomTheme {
        //Home()
    }
}
