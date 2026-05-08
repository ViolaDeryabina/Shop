package com.example.shop.presentation.components

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxDefaults
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.screens.DataOrders
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Функция для создания компонента CartBasket
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
data class DataCartBasket(
    val bitmap: ImageBitmap,
    val title: String,
    val price: Int
)

data class DataCartBasketOrder(
    val bitmap: ImageBitmap,
    val title: String,
    val price: Int,
    val count: Int
)

@Composable
fun CartBasket(
    modifier: Modifier = Modifier,
    dataCartBasket: DataCartBasket? = null,
    dataOrder: DataOrders? = null,
    dataCartBasketOrder: DataCartBasketOrder? = null
) {
    logInfo("CartBasket", "Создание компонента", "Отрисовка CartBasket")

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardColors(
            containerColor = CustomTheme.colors.block,
            contentColor = CustomTheme.colors.text,
            disabledContainerColor = CustomTheme.colors.block,
            disabledContentColor = CustomTheme.colors.text,
        )
    ) {
        Row(
            modifier = Modifier.padding(top = 10.dp, start = 10.dp, bottom = 9.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (dataOrder != null) {
                Box(
                    modifier = Modifier
                        .size(86.dp)
                        .weight(1f)
                        .background(
                            CustomTheme.colors.background,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(dataOrder.bitmap),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Column(modifier = Modifier.weight(1.5f)) {
                    Text(
                        text = "№ ${dataOrder.code}",
                        style = CustomTheme.typography.BodyRegular14,
                        color = CustomTheme.colors.accent
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Text(
                        text = dataOrder.title,
                        style = CustomTheme.typography.BodyRegular14,
                        color = CustomTheme.colors.text
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row() {
                        Text(
                            text = "₽${dataOrder.price}",
                            style = CustomTheme.typography.BodyRegular14,
                            color = CustomTheme.colors.text
                        )
                        Spacer(modifier = Modifier.width(30.dp))

                        Text(
                            text = "₽${dataOrder.priceNew}",
                            style = CustomTheme.typography.BodyRegular14,
                            color = CustomTheme.colors.hint
                        )
                    }
                }
                if (dataOrder.timeString == "") {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "${dataOrder.time} минут назад",
                        style = CustomTheme.typography.BodyRegular14,
                        color = CustomTheme.colors.hint
                    )
                } else {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = dataOrder.timeString ?: "",
                        style = CustomTheme.typography.BodyRegular14,
                        color = CustomTheme.colors.hint
                    )
                }
            } else if (dataCartBasket != null) {
                Box(
                    modifier = Modifier
                        .height(85.dp)
                        .width(87.dp)
                        .background(
                            CustomTheme.colors.background,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(dataOrder?.bitmap ?: R.drawable.bot),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Column() {
                    Text(
                        text = dataCartBasket.title,
                        style = CustomTheme.typography.BodyRegular16,
                        color = CustomTheme.colors.text
                    )
                    Text(
                        text = "₽${dataCartBasket.price}",
                        style = CustomTheme.typography.BodyRegular16,
                        color = CustomTheme.colors.text
                    )
                }
            } else if (dataCartBasketOrder != null) {
                Box(
                    modifier = Modifier
                        .height(85.dp)
                        .width(87.dp)
                        .background(
                            CustomTheme.colors.background,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        bitmap = dataCartBasketOrder.bitmap,
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                ) {
                    Text(
                        text = dataCartBasketOrder.title,
                        style = CustomTheme.typography.BodyRegular16,
                        color = CustomTheme.colors.text
                    )
                    Row(
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        Text(
                            text = "₽${dataCartBasketOrder.price}",
                            style = CustomTheme.typography.BodyRegular16,
                            color = CustomTheme.colors.text
                        )
                        Spacer(modifier = Modifier.width(30.dp))
                        Text(
                            text = "₽${dataCartBasketOrder.count} шт",
                            style = CustomTheme.typography.BodyRegular16,
                            color = CustomTheme.colors.hint
                        )
                    }

                }
            }
        }
    }
}

@Preview
@Composable
private fun CartBasketPrev() {
    CustomTheme {
        val dismissState = rememberSwipeToDismissBoxState()
        LaunchedEffect(dismissState.currentValue) {
            when (dismissState.currentValue) {
                SwipeToDismissBoxValue.EndToStart -> {
                    println("Удалено")
                }
                SwipeToDismissBoxValue.StartToEnd -> {
                    dismissState.snapTo(SwipeToDismissBoxValue.Settled)
                }
                SwipeToDismissBoxValue.Settled -> {}
            }
        }
        SwipeToDismissBox(
            state = dismissState,
            enableDismissFromStartToEnd = true,
            enableDismissFromEndToStart = true,
            backgroundContent = {
                val direction = dismissState.dismissDirection
                val backgroundColor = when (direction) {
                    SwipeToDismissBoxValue.StartToEnd -> CustomTheme.colors.accent
                    SwipeToDismissBoxValue.EndToStart -> CustomTheme.colors.red
                    else -> Color.Transparent
                }
                val swipe = when (direction) {
                    SwipeToDismissBoxValue.StartToEnd -> "left"
                    SwipeToDismissBoxValue.EndToStart -> "right"
                    else -> ""
                }
                if (swipe == "left") {
                    Box(
                        Modifier
                            .fillMaxSize()
                            .weight(1.5f)
                            .background(
                                backgroundColor,
                                RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.update),
                            contentDescription = "",
                            tint = CustomTheme.colors.block
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    CartBasket(
                        modifier = Modifier.weight(8f),
                        dataCartBasketOrder = DataCartBasketOrder(
                            bitmap = ImageBitmap.imageResource(R.drawable.bot),
                            title = "Nike Club Max",
                            price = 584,
                            count = 1
                        )
                    )
                } else if (swipe == "right") {
                    CartBasket(
                        modifier = Modifier.weight(8f),
                        dataCartBasketOrder = DataCartBasketOrder(
                            bitmap = ImageBitmap.imageResource(R.drawable.bot),
                            title = "Nike Club Max",
                            price = 584,
                            count = 1
                        )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(
                        Modifier
                            .fillMaxSize()
                            .weight(1.5f)
                            .background(
                                backgroundColor,
                                RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.delete),
                            contentDescription = "",
                            tint = CustomTheme.colors.block
                        )
                    }
                }
            }
        ) {
            CartBasket(
                dataCartBasketOrder = DataCartBasketOrder(
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Club Max",
                    price = 584,
                    count = 1
                )
            )
        }
    }
}