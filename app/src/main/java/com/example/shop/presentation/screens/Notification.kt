package com.example.shop.presentation.screens

import android.accessibilityservice.GestureDescription
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.presentation.components.BottomBar
import com.example.shop.presentation.logDebug
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.navigation.Catalog
import com.example.shop.presentation.theme.CustomTheme
import kotlinx.coroutines.launch

//Назначение: Создание экрана
//Автор: Дерябина В.Н.
//Дата: 30.04.2026

data class DataNotification(
    val title: String,
    val description: String,
    val date: String
)

@Composable
fun Notification(modifier: Modifier = Modifier) {
    logInfo("Notification", "Создание экрана", "Отрисовка экрана для ***")
    logDebug("Notification", "Нажатие кнопки", "Переход ***")

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 22.dp, start = 18.dp, top = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(CustomTheme.colors.block)
                        .size(44.dp), onClick = {

                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.clock_1),
                        contentDescription = "",
                        modifier = Modifier
                            .size(25.71.dp)
                    )
                }
                Text(
                    text = "Уведомления",
                    style = CustomTheme.typography.BodyRegular16,
                    color = CustomTheme.colors.text
                )

                Spacer(modifier = Modifier.size(44.dp))

            }
        },
        bottomBar = {
            BottomBar(
                selectedInt = 2,
                homeOnClick = { },
                favoriteOnClick = {

                },
                notificationOnClick = { },
                profileOnClick = { },
                basketOnClick = { }
            )
        },
        containerColor = CustomTheme.colors.block
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val list = listOf(
                DataNotification(
                    title = "Заголовок",
                    description = "Lorem ipsum dolor sit amet consectetur. Venenatis pulvinar lobortis risus consectetur morbi egestas id in bibendum. Volutpat nulla urna sit sed diam nulla.",
                    date = "27.01.2024, 15:42"
                ),
                DataNotification(
                    title = "Заголовок",
                    description = "Lorem ipsum dolor sit amet consectetur. Venenatis pulvinar lobortis risus consectetur morbi egestas id in bibendum. Volutpat nulla urna sit sed diam nulla.",
                    date = "27.01.2024, 15:42"
                ),
                DataNotification(
                    title = "Заголовок",
                    description = "Lorem ipsum dolor sit amet consectetur. Venenatis pulvinar lobortis risus consectetur morbi egestas id in bibendum. Volutpat nulla urna sit sed diam nulla.",
                    date = "27.01.2024, 15:42"
                ),
                DataNotification(
                    title = "Заголовок",
                    description = "Lorem ipsum dolor sit amet consectetur. Venenatis pulvinar lobortis risus consectetur morbi egestas id in bibendum. Volutpat nulla urna sit sed diam nulla.",
                    date = "27.01.2024, 15:42"
                ),
                DataNotification(
                    title = "Заголовок",
                    description = "Lorem ipsum dolor sit amet consectetur. Venenatis pulvinar lobortis risus consectetur morbi egestas id in bibendum. Volutpat nulla urna sit sed diam nulla.",
                    date = "27.01.2024, 15:42"
                )
            )
            LazyColumn() {
                items(list) { it ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .background(CustomTheme.colors.background, RoundedCornerShape(16.dp)),
                        ) {
                        Text(
                            text = it.title,
                            style = CustomTheme.typography.BodyRegular20,
                            color = CustomTheme.colors.text
                        )
                        Text(
                            text = it.description,
                            style = CustomTheme.typography.BodyRegular20,
                            color = CustomTheme.colors.text
                        )
                        Text(
                            text = it.date,
                            style = CustomTheme.typography.BodyRegular20,
                            color = CustomTheme.colors.text
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun NotificationPrev() {
    CustomTheme {
        Notification()
    }
}