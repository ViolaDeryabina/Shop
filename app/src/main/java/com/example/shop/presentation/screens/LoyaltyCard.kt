package com.example.shop.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.presentation.components.ScreenHeader
import com.example.shop.presentation.logDebug
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun LoyaltyCard(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    logInfo("Map", "Создание экрана", "Отрисовка экрана Карта")
    Scaffold(
        topBar = {
            Spacer(modifier = Modifier.height(12.dp))
            ScreenHeader(
                title = "Карта лояльности",
                onBackClick = {
                    logDebug("LoyaltyCard", "Нажатие на кнопку", "Переход назад по стэку")
                    navController.popBackStack()
                },
                modifier = Modifier.padding(horizontal = 20.dp),
            )
        },
        containerColor = CustomTheme.colors.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.bar_code_fill),
                contentDescription = "",
                modifier = Modifier.fillMaxHeight(),
                contentScale = ContentScale.FillHeight
            )
        }
    }
}

@Preview
@Composable
private fun LoyaltyCardPrev() {
    CustomTheme {
        LoyaltyCard()
    }
}