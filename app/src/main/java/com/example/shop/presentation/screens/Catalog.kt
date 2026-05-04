package com.example.shop.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.data.Product
import com.example.shop.presentation.components.CustomCard
import com.example.shop.presentation.components.ListCategory
import com.example.shop.presentation.components.ScreenHeader
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание экрана каталог
//Автор: Дерябина В.Н.
//Дата: 30.04.2026

@Composable
fun Catalog(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    val scroll = rememberScrollState()
    val products = remember {
        List(8) {
            Product("Nike Air Max", "Best Seller", 752, R.drawable.bot)
        }
    }
    Scaffold(
        topBar = {
            ScreenHeader(
                title = "Outdoor",
                onBackClick = { navController.popBackStack() },
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        },
        containerColor = CustomTheme.colors.background
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item(span = { GridItemSpan(2) }) {
                Column {
                    Text(
                        text = "Категории",
                        style = CustomTheme.typography.BodyRegular16,
                        color = CustomTheme.colors.text
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    ListCategory(
                        list = listOf("Все", "Outdoor", "Tennis"),
                        onClick = {}
                    )
                }
            }

            items(products) { product ->
                CustomCard(
                    bitmap = ImageBitmap.imageResource(product.imageRes),
                    title = product.title,
                    category = product.category,
                    price = product.price,
                    heart = true
                )
            }
        }
    }
}

@Preview
@Composable
private fun CatalogPrev() {
    CustomTheme {
        Catalog()
    }
}