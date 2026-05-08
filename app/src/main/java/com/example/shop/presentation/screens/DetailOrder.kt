package com.example.shop.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.presentation.components.CartBasket
import com.example.shop.presentation.components.DataCartBasketOrder
import com.example.shop.presentation.components.ScreenHeader
import com.example.shop.presentation.logDebug
import com.example.shop.presentation.navigation.Map
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun DetailOrder(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    val scroll = rememberScrollState()
    Scaffold(
        topBar = {
            Spacer(modifier = Modifier.height(12.dp))
            ScreenHeader(
                title = "325556516",
                onBackClick = {
                    logDebug("DetailOrder", "Нажатие на кнопку", "Переход назад по стэку")
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

            val listOrder = listOf(
                DataCartBasketOrder(
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Club Max",
                    price = 584,
                    count = 1
                ), DataCartBasketOrder(
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Club Max",
                    price = 584,
                    count = 1
                )
            )
            listOrder.forEach { it ->
                CartBasket(
                    dataCartBasketOrder = it
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        CustomTheme.colors.block,
                        RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Text(
                    text = "Контактная информация",
                    style = CustomTheme.typography.BodyMedium14,
                    color = CustomTheme.colors.text
                )

                val list = listOf<Info>(
                    Info(R.drawable.email, "Email", "*******@****.***"),
                    Info(R.drawable.call, "Телефон", "**-***-***-****")
                )
                list.forEach { it ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row() {
                            Box(
                                modifier = Modifier
                                    .background(
                                        CustomTheme.colors.background,
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .size(40.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(it.image),
                                    contentDescription = "",
                                    tint = CustomTheme.colors.text,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column() {
                                Text(
                                    text = it.placeholder,
                                    style = CustomTheme.typography.BodyMedium14,
                                    color = CustomTheme.colors.text
                                )
                                Text(
                                    text = it.info,
                                    style = CustomTheme.typography.BodyRegular12,
                                    color = CustomTheme.colors.hint
                                )
                            }
                        }
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.edit),
                            contentDescription = "",
                            tint = CustomTheme.colors.hint,
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Адрес",
                    style = CustomTheme.typography.BodyMedium14,
                    color = CustomTheme.colors.text
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "1082 Аэропорт, Нигерии",
                        style = CustomTheme.typography.BodyRegular12,
                        color = CustomTheme.colors.hint
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.edit),
                        contentDescription = "",
                        tint = CustomTheme.colors.hint,
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = {
                            Log.d(
                                "CheckoutEmpty",
                                "Нажатие на кнопку - Переход на экран Map"
                            )
                            navController.navigate(
                                Map
                            )
                        })
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.carta),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 20.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Посмотреть на карте",
                            style = CustomTheme.typography.HeadingRegular20,
                            color = CustomTheme.colors.block
                        )
                        Box(
                            modifier = Modifier
                                .background(CustomTheme.colors.accent, CircleShape)
                                .size(
                                    36.dp
                                ), contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.marker),
                                contentDescription = "",
                                tint = CustomTheme.colors.block,
                                modifier = Modifier
                                    .size(25.dp)
                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Способ оплаты",
                    style = CustomTheme.typography.BodyMedium14,
                    color = CustomTheme.colors.text
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row() {
                        Box(
                            modifier = Modifier
                                .background(
                                    CustomTheme.colors.background,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .size(40.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                bitmap = ImageBitmap.imageResource(R.drawable.image_55),
                                contentDescription = "",
                                modifier = Modifier.size(32.dp, 22.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Добавить",
                                style = CustomTheme.typography.BodyRegular14,
                                color = CustomTheme.colors.text
                            )
                            Text(
                                text = "**** *****",
                                style = CustomTheme.typography.BodyRegular12,
                                color = CustomTheme.colors.hint
                            )
                        }
                    }
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.arrow_down),
                        contentDescription = "",
                        tint = CustomTheme.colors.hint,
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun DetailOrderPrev() {
    CustomTheme {
        DetailOrder()
    }
}