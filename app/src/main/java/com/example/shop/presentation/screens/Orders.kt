package com.example.shop.presentation.screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
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
    val timeString: String? = ""
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
            val listToday = listOf(
                DataOrders(
                    bitmap = R.drawable.bot,
                    title = "Nike Air Max 270 Essential",
                    price = 584,
                    priceNew = 260,
                    time = 7,
                    code = "325556516"
                ),
                DataOrders(
                    bitmap = R.drawable.bot,
                    title = "Nike Air Max 270 Essential",
                    price = 584,
                    priceNew = 260,
                    time = 7,
                    code = "325556516"
                )
            )
            Spacer(modifier = Modifier.height(11.dp))
            val list = listOf(
                DataOrders(
                    bitmap = R.drawable.bot,
                    title = "Nike Air Max 270 Essential",
                    price = 584,
                    priceNew = 260,
                    timeString = "10:23",
                    code = "325556516"
                ),
                DataOrders(
                    bitmap = R.drawable.bot,
                    title = "Nike Air Max 270 Essential",
                    price = 584,
                    priceNew = 260,
                    timeString = "10:23",
                    code = "325556516"
                ),
                DataOrders(
                    bitmap = R.drawable.bot,
                    title = "Nike Air Max 270 Essential",
                    price = 584,
                    priceNew = 260,
                    timeString = "10:23",
                    code = "325556516"
                )
            )
            listToday.forEach { it ->
                CartBasket(
                    dataOrder = DataOrders(
                        bitmap = it.bitmap,
                        title = it.title,
                        price = it.price,
                        priceNew = it.priceNew,
                        time = it.time ?: 0,
                        code = it.code
                    )
                )
                Spacer(modifier = Modifier.height(13.dp))
            }

            Text(
                text = "Вчера",
                style = CustomTheme.typography.BodyRegular16,
                color = CustomTheme.colors.text
            )
            Spacer(modifier = Modifier.height(11.dp))

            list.forEach { it ->
                CartBasket(
                    dataOrder = DataOrders(
                        it.bitmap,
                        title = it.title,
                        price = it.price,
                        priceNew = it.priceNew,
                        timeString = it.timeString ?: "",
                        code = it.code
                    )
                )
                Spacer(modifier = Modifier.height(13.dp))

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