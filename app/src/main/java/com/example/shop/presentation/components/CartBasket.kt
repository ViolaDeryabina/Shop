package com.example.shop.presentation.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Функция для создания компонента CartBasket
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun CartBasket(
    modifier: Modifier = Modifier,
    bitmap: ImageBitmap,
    title: String,
    price: Int
) {
    logInfo("CartBasket","Создание компонента","Отрисовка CartBasket")

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
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
                    bitmap = bitmap,
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.width(30.dp))
            Column() {
                Text(
                    text = title,
                    style = CustomTheme.typography.BodyRegular16,
                    color = CustomTheme.colors.text
                )
                Text(
                    text = "₽${price}",
                    style = CustomTheme.typography.BodyRegular16,
                    color = CustomTheme.colors.text
                )

            }
        }
    }
}

@Preview
@Composable
private fun CartBasketPrev() {
    CustomTheme {
        CartBasket(
            bitmap = ImageBitmap.imageResource(R.drawable.bot),
            title = "Nike Club Max",
            price = 584
        )
    }
}