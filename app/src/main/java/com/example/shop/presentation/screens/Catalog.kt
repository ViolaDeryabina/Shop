package com.example.shop.presentation.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.shop.R
import com.example.shop.presentation.components.CustomCard
import com.example.shop.presentation.components.ListCategory
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun Catalog(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomTheme.colors.background)
    ) {
        Column(
            modifier = modifier
                .padding(start = 20.dp)
                .fillMaxSize()
                .background(CustomTheme.colors.background)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(CustomTheme.colors.block)
                        .size(44.dp), onClick = {  }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.direction_left),
                        contentDescription = "",
                        modifier = Modifier
                            .size(14.dp)
                    )
                }
                Text(
                    text = "Outdoor",
                    style = CustomTheme.typography.BodyRegular16,
                    color = CustomTheme.colors.text
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Категории",
                    style = CustomTheme.typography.BodyRegular16,
                    color = CustomTheme.colors.text
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            ListCategory(
                list = listOf(
                    "Все","Outdoor","Tennis"
                ),
                onClick = {}
            )
            Spacer(modifier = Modifier.height(18.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
                )
                Spacer(modifier = Modifier.width(15.dp))
                CustomCard(
                    modifier = Modifier.weight(0.42f),
                    bitmap = ImageBitmap.imageResource(R.drawable.bot),
                    title = "Nike Air Max",
                    category = "Best Seller",
                    price = 752,
                    heart = true
                )
            }
        }
    }
}

@Preview
@Composable
private fun CatalogPrev() {
    CustomTheme{
        Catalog() 
    }
}