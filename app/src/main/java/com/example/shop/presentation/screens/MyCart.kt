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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.presentation.components.BottomBar
import com.example.shop.presentation.components.CartBasket
import com.example.shop.presentation.components.PrimaryButton
import com.example.shop.presentation.components.ScreenHeader
import com.example.shop.presentation.logDebug
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.navigation.Catalog
import com.example.shop.presentation.navigation.CheckoutEmpty
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание экрана для отображение корзины
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun MyCart(modifier: Modifier = Modifier,navController: NavController) {
    val scroll = rememberScrollState()
    logInfo("MyCart","Создание экрана","Отрисовка экрана MyCart")

    Scaffold(
        topBar = {
            Spacer(modifier = Modifier.height(12.dp))
            ScreenHeader(
                title = "Корзина",
                onBackClick = {
                    logDebug("MyCart","Нажатие кнопки","Переход назад по стэку")
                    navController.popBackStack()
                },
                modifier = Modifier.padding(horizontal = 20.dp),
            )
        },
        containerColor = CustomTheme.colors.background
    ){ innerPadding ->
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxSize().padding(innerPadding)
                    .weight(0.7f)
                    .background(CustomTheme.colors.background)
            ) {
                Column(
                    modifier = modifier
                        .verticalScroll(scroll)
                        .padding(horizontal = 20.dp)
                        .fillMaxSize()
                        .background(CustomTheme.colors.background)
                ) {
                    Spacer(modifier = Modifier.height(48.dp))
                    CartBasket(
                        bitmap =  ImageBitmap.imageResource(R.drawable.bot),
                        title = "Nike Club Max",
                        price = 584
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    CartBasket(
                        bitmap =  ImageBitmap.imageResource(R.drawable.bot),
                        title = "Nike Club Max",
                        price = 584
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    CartBasket(
                        bitmap = ImageBitmap.imageResource(R.drawable.bot),
                        title = "Nike Club Max",
                        price = 584
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.3f)
                    .background(CustomTheme.colors.block)
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(scroll)
                        .padding(horizontal = 20.dp)
                        .fillMaxSize()
                ) {
                    Spacer(modifier= Modifier.height(36.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Сумма",
                            style = CustomTheme.typography.BodyRegular16,
                            color = CustomTheme.colors.subTextDark
                        )
                        Text(
                            text = "₽753.95",
                            style = CustomTheme.typography.BodyRegular16,
                            color = CustomTheme.colors.text
                        )
                    }
                    Spacer(modifier= Modifier.height(11.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Доставка",
                            style = CustomTheme.typography.BodyRegular16,
                            color = CustomTheme.colors.subTextDark
                        )
                        Text(
                            text = "₽60.20",
                            style = CustomTheme.typography.BodyRegular16,
                            color = CustomTheme.colors.text
                        )
                    }
                    Spacer(modifier= Modifier.height(34.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Итого",
                            style = CustomTheme.typography.BodyRegular16,
                            color = CustomTheme.colors.text
                        )
                        Text(
                            text = "₽814.15",
                            style = CustomTheme.typography.BodyRegular16,
                            color = CustomTheme.colors.accent
                        )
                    }
                    Spacer(modifier= Modifier.height(33.dp))
                    PrimaryButton(
                        onClick = {
                            logDebug("MyCart","Нажатие кнопки","Переход на экран CheckoutEmpty для оформления заказа")
                            navController.navigate(CheckoutEmpty)
                        },
                        text = "Оформить заказ",
                        enabled = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier= Modifier.height(32.dp))
                }
            }
        }
    }


}

@Preview
@Composable
private fun MyCartPrev() {
    CustomTheme {
//        MyCart()
    }
}