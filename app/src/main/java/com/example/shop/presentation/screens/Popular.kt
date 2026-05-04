package com.example.shop.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.presentation.components.CustomCard
import com.example.shop.presentation.navigation.Catalog
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание экрана Popular для отображения популятрных позиций
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun Popular(modifier: Modifier = Modifier, navController: NavController) {
    val scroll = rememberScrollState()
    Log.i("Popular", "Создание экрана Popular")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomTheme.colors.background)
    ) {
        Column(
            modifier = modifier
                .verticalScroll(scroll)
                .padding(start = 20.dp)
                .fillMaxSize()
                .background(CustomTheme.colors.background)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(CustomTheme.colors.block)
                        .size(44.dp), onClick = {
                        Log.d("Popular", "Нажатие кнопки для перехода назад")
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.direction_left),
                        contentDescription = "",
                        modifier = Modifier
                            .size(14.dp)
                    )
                }
                Text(
                    text = "Популярное",
                    style = CustomTheme.typography.BodyRegular16,
                    color = CustomTheme.colors.text
                )

                IconButton(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(CustomTheme.colors.block)
                        .size(40.dp), onClick = {
                        Log.d("Popular", "Нажатие кнопки для перехода на экран Catalog")

                        navController.navigate(Catalog)
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.favorite),
                        contentDescription = "",
                        tint = CustomTheme.colors.text,
                        modifier = Modifier
                            .size(30.dp)
                            .offset(y = (2).dp)
                    )
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
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
                    heart = true
                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
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
                    heart = true
                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
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
                    heart = true
                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
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
                    heart = true
                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
                )
            }
        }
    }
}

@Preview
@Composable
private fun PopularPrev() {
    CustomTheme {
        //Popular()
    }
}