package com.example.shop.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

@Composable
fun CartBasketFullInfo(
    modifier: Modifier = Modifier,
    bitmap: ImageBitmap,
    title: String,
    price: Int,
    priceNew: Int,
    time: Int=0,
    timeString: String="",
    code: String
) {
    logInfo("CartBasket", "Создание компонента", "Отрисовка CartBasket")

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
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
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
                    bitmap = bitmap,
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.width(30.dp))
            Column(modifier = Modifier.weight(1.5f)) {
                Text(
                    text = "№ ${code}",
                    style = CustomTheme.typography.BodyRegular14,
                    color = CustomTheme.colors.accent
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = title,
                    style = CustomTheme.typography.BodyRegular14,
                    color = CustomTheme.colors.text
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row() {
                    Text(
                        text = "₽${price}       ",
                        style = CustomTheme.typography.BodyRegular14,
                        color = CustomTheme.colors.text
                    )
                    Text(
                        text = "₽${priceNew}",
                        style = CustomTheme.typography.BodyRegular14,
                        color = CustomTheme.colors.hint
                    )
                }
            }
            if(timeString.isEmpty()){
                Text(
                    modifier= Modifier.weight(1f),
                    text = "${time} минут назад",
                    style = CustomTheme.typography.BodyRegular14,
                    color = CustomTheme.colors.hint
                )
            }else{
                Text(
                    modifier= Modifier.weight(1f),
                    text = timeString,
                    style = CustomTheme.typography.BodyRegular14,
                    color = CustomTheme.colors.hint
                )
            }

        }
    }
}

@Preview
@Composable
private fun CartBasketFullInfoPrev() {
    CustomTheme {
        CartBasketFullInfo(
            bitmap = ImageBitmap.imageResource(R.drawable.bot),
            title = "Nike Air Max 270 Essential",
            price = 584,
            priceNew = 260,
            time = 7,
            code = "325556516"
        )
    }
}