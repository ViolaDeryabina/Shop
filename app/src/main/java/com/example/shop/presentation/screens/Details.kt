package com.example.shop.presentation.screens

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.presentation.components.CardButton
import com.example.shop.presentation.components.PrimaryButton
import com.example.shop.presentation.components.ScreenHeader
import com.example.shop.presentation.logDebug
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание экрана просмотра информации о товаре
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun Details(modifier: Modifier = Modifier, navController: NavController= rememberNavController()) {
    var maxLines by remember { mutableIntStateOf(3) }
    logInfo("Details","Создание экрана","Создание экрана Details")

    Scaffold(
        topBar = {
            ScreenHeader(
                title = "Sneaker Shop",
                onBackClick = {
                    logDebug("Details","Нажатие на кнопку","Переход назад по стэку")

                    navController.popBackStack()
                },
                modifier = Modifier.padding(horizontal = 20.dp),
                icon = {
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
                                    .size(24.dp)

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
            )
        },
        containerColor = CustomTheme.colors.background
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                modifier = Modifier.width(259.dp),
                text = "Nike Air Max 270 Essential",
                style = CustomTheme.typography.HeadingRegular26,
                color = CustomTheme.colors.text
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Men’s Shoes",
                style = CustomTheme.typography.BodyRegular16,
                color = CustomTheme.colors.hint
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "₽179.39",
                style = CustomTheme.typography.BodyRegular24,
                color = CustomTheme.colors.text
            )
            Spacer(modifier = Modifier.height(65.dp))
            val rowBitmap = listOf(
                R.drawable.hero_image,
                R.drawable.two_image,
                R.drawable.three_image,
                R.drawable.bot,
                R.drawable.five_inage,
                R.drawable.hero_image
            )
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    bitmap = ImageBitmap.imageResource(R.drawable.bot_podium),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
                Image(
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .size(width = 241.dp, height = 125.dp)
                        .offset(y = (-50).dp)
                )

            }
            Spacer(modifier = Modifier.height(37.dp))

            LazyRow() {
                items(rowBitmap) { item ->
                    CardButton(bitmap = item)
                    Spacer(modifier = Modifier.width(14.dp))
                }
            }
            Spacer(modifier = Modifier.height(33.dp))
            Text(
                text = "Вставка Max Air 270 обеспечивает непревзойденный комфорт в течение всего дня. Изящный дизайн Задача организации, в особенности же убеждённость некоторых оппонентов способствует повышению качества существующих финансовых и административных условий. Не следует, однако, забывать, что реализация намеченных плановых заданий требует анализа благоприятных перспектив. Мы вынуждены отталкиваться от того, что высококачественный прототип будущего проекта способствует повышению качества направлений прогрессивного развития! ",
                style = CustomTheme.typography.BodyRegular14,
                color = CustomTheme.colors.hint,
                maxLines = maxLines,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Text(
                    text = "Подробнее",
                    style = CustomTheme.typography.BodyRegular14,
                    color = CustomTheme.colors.accent,
                    modifier = Modifier.clickable(onClick = { maxLines = 100 })
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row() {
                IconButton(
                    modifier = Modifier
                        .size(52.dp)
                        .background(Color(0xFFD9D9D9).copy(0.4f), CircleShape), onClick = {}
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.favorite),
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                            .offset(y = 2.dp)
                    )
                }
                Spacer(modifier = Modifier.width(18.dp))
                PrimaryButton(
                    onClick = {}, text = "В корзину",
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.bag_2),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }, enabled = true, modifier = Modifier.weight(0.8f)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))

        }
    }
}


@Preview
@Composable
private fun DetailsPrev() {
    CustomTheme {
        Details()
    }
}