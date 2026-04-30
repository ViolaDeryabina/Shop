package com.example.shop.presentation.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.presentation.theme.CustomTheme
import com.example.shop.presentation.theme.Text

//Назначение: Создание компонента отображения карточек товара
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    bitmap: ImageBitmap,
    title: String,
    category: String,
    price: Int,
    heart: Boolean=false
) {
    Log.i("CustomCard","Создание компонента отображения карточек товара")

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardColors(
            containerColor = CustomTheme.colors.block,
            contentColor = CustomTheme.colors.text,
            disabledContainerColor = CustomTheme.colors.block,
            disabledContentColor = CustomTheme.colors.text,
        )
    ) {
        Column(
            modifier = Modifier
                .padding(start = 9.dp, top = 9.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .background(CustomTheme.colors.background, shape = CircleShape)
                    .clickable(onClick = {}),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(if(!heart) R.drawable.favorite else R.drawable.path),
                    contentDescription = "",
                    tint = if(!heart) CustomTheme.colors.text else CustomTheme.colors.red,
                    modifier = Modifier
                        .size(20.dp)
                        .offset(y = (2).dp)
                )

            }

            Image(
                bitmap = bitmap,
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 21.dp, start = 12.dp)
                    .offset(y = (-15).dp)
            )
            Text(
                text = category,
                style = CustomTheme.typography.BodyRegular16,
                color = CustomTheme.colors.accent
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                style = CustomTheme.typography.BodyRegular16,
                color = CustomTheme.colors.hint
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "₽${price}")
                IconButton(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp))
                        .background(CustomTheme.colors.accent)
                        .size(40.dp), onClick = {}
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.add),
                        contentDescription = "",
                        tint = CustomTheme.colors.block,
                        modifier = Modifier
                            .size(30.dp)
                            .offset(y = (2).dp)
                    )
                }

            }

        }
    }
}

@Preview
@Composable
private fun CustomCardPrev() {
    CustomTheme {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            CustomCard(
                modifier = Modifier.weight(0.42f),
                bitmap = ImageBitmap.imageResource(R.drawable.bot),
                title = "Nike Air Max",
                category = "Best Seller",
                price = 752
            )
            Spacer(modifier = Modifier.width(15.dp))
            CustomCard(
                modifier = Modifier.weight(0.42f),
                bitmap = ImageBitmap.imageResource(R.drawable.bot),
                title = "Nike Air Max",
                category = "Best Seller",
                price = 752
            )
        }

    }
}