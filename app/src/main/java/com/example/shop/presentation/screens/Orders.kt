package com.example.shop.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.presentation.components.CartBasket
import com.example.shop.presentation.components.ScreenHeader
import com.example.shop.presentation.logDebug
import com.example.shop.presentation.theme.CustomTheme


data class DataOrders(
    val bitmap: Int,
    val title: String,
    val price: Int,
    val priceNew: Int,
    val time: Int? = null,
    val code: String,
    val timeString: String? = "",
    val id: Int?=0,
    val isRemoved: Boolean = false
)

@Composable
fun Orders(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    val scroll = rememberScrollState()
    Scaffold(
        topBar = {
            Spacer(modifier = Modifier.height(12.dp))
            ScreenHeader(
                title = "Заказы",
                onBackClick = {
                    logDebug("Orders", "Нажатие на кнопку", "Переход назад по стэку")
                    navController.popBackStack()
                },
                modifier = Modifier.padding(horizontal = 20.dp),
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .scrollable(scroll, orientation = Orientation.Vertical)
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Недавний",
                style = CustomTheme.typography.BodyRegular16,
                color = CustomTheme.colors.text
            )
            val listToday = remember {
                mutableListOf(
                    DataOrders(
                        bitmap = R.drawable.bot,
                        title = "Nike Air Max 270 Essential",
                        price = 584,
                        priceNew = 260,
                        time = 7,
                        code = "325556516",
                        id = 0
                    ),
                    DataOrders(
                        bitmap = R.drawable.bot,
                        title = "Nike Air Max 270 Essential",
                        price = 584,
                        priceNew = 260,
                        time = 7,
                        code = "325556516",
                        id = 1
                    ),
                    DataOrders(
                        bitmap = R.drawable.bot,
                        title = "Nike Air Max 270 Essential",
                        price = 584,
                        priceNew = 260,
                        timeString = "10:23",
                        code = "325556516",
                        id=2
                    ),
                    DataOrders(
                        bitmap = R.drawable.bot,
                        title = "Nike Air Max 270 Essential",
                        price = 584,
                        priceNew = 260,
                        timeString = "10:23",
                        code = "325556516",
                        id=3
                    ),
                    DataOrders(
                        bitmap = R.drawable.bot,
                        title = "Nike Air Max 270 Essential",
                        price = 584,
                        priceNew = 260,
                        timeString = "10:23",
                        code = "325556516",
                        id=4
                    )
                )

            }
            Spacer(modifier = Modifier.height(11.dp))

            listToday.forEachIndexed { index, it ->
                if(it.id==2){
                    Text(
                        text = "Вчера",
                        style = CustomTheme.typography.BodyRegular16,
                        color = CustomTheme.colors.text
                    )
                    Spacer(modifier = Modifier.height(11.dp))
                }
                if (!it.isRemoved) {
                    val dismissState = rememberSwipeToDismissBoxState()

                    LaunchedEffect(dismissState.currentValue) {
                        if (dismissState.currentValue != SwipeToDismissBoxValue.Settled) {
                            if (dismissState.currentValue == SwipeToDismissBoxValue.EndToStart) {

                                logDebug("", "Удаление", "${it.id}")
                                println("Удаление: ${it.id}")
                                listToday[index] = it.copy(isRemoved = true)
                            }
                            dismissState.snapTo(SwipeToDismissBoxValue.Settled)
                        }
                    }
                    SwipeToDismissBox(
                        state = dismissState,
                        enableDismissFromStartToEnd = true,
                        enableDismissFromEndToStart = true,
                        backgroundContent = {
                            val direction = dismissState.dismissDirection

                            Row(modifier = Modifier.fillMaxSize()) {
                                if (direction == SwipeToDismissBoxValue.StartToEnd) {
                                    Box(
                                        Modifier.fillMaxHeight().weight(1.5f)
                                            .background(
                                                CustomTheme.colors.accent,
                                                RoundedCornerShape(8.dp)
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = ImageVector.vectorResource(R.drawable.update),
                                            contentDescription = null,
                                            tint = CustomTheme.colors.block
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(8f))
                                } else if (direction == SwipeToDismissBoxValue.EndToStart) {
                                    Spacer(modifier = Modifier.weight(8f))
                                    Box(
                                        Modifier.fillMaxHeight().weight(1.5f)
                                            .background(
                                                CustomTheme.colors.red,
                                                RoundedCornerShape(8.dp)
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = ImageVector.vectorResource(R.drawable.delete),
                                            contentDescription = null,
                                            tint = CustomTheme.colors.block
                                        )
                                    }
                                }
                            }
                        }

                    ) {
                        CartBasket(
                            dataOrder = DataOrders(
                                bitmap = it.bitmap,
                                title = it.title,
                                price = it.price,
                                priceNew = it.priceNew,
                                time = it.time ?: 0,
                                code = it.code,
                                timeString = it.timeString
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(13.dp))
                }
            }

        }
    }
}

@Preview
@Composable
private fun OrdersPrev() {
    CustomTheme {
        Orders()
    }
}