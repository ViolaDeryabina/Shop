package com.example.shop.presentation.components


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.presentation.theme.CustomTheme


@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    selectedInt: Int,
    homeOnClick: () -> Unit,
    favoriteOnClick: () -> Unit,
    notificationOnClick: () -> Unit,
    profileOnClick: () -> Unit,
    basketOnClick: () -> Unit,
) {

    Log.i("BottomBar", "Создание компонента BottomBar")
    Box(modifier = modifier.fillMaxWidth()) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.bottom_bar),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 45.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.home),
                contentDescription = "",
                tint = if (selectedInt == 0) CustomTheme.colors.accent else CustomTheme.colors.subTextDark,
                modifier = Modifier
                    .clickable(onClick = {
                        Log.d("BottomBar", "Нажатие на кнопку home")

                        homeOnClick()
                    })
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.favorite),
                contentDescription = "",
                tint = if (selectedInt == 1) CustomTheme.colors.accent else CustomTheme.colors.subTextDark,
                modifier = Modifier
                    .clickable(onClick = {
                        Log.d("BottomBar", "Нажатие на кнопку favorite")
                        favoriteOnClick()
                    })
            )
            FloatingActionButton(
                onClick = { basketOnClick() },
                shape = CircleShape,
                containerColor = CustomTheme.colors.accent,
                modifier = Modifier.offset(y = (-35).dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.bag_2),
                    contentDescription = "",
                    tint = CustomTheme.colors.block,
                    modifier = Modifier
                        .clickable(onClick = {
                            Log.d("BottomBar", "Нажатие на кнопку корзина")
                            basketOnClick()
                        })
                )
            }
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.notification),
                contentDescription = "",
                tint = if (selectedInt == 2) CustomTheme.colors.accent else CustomTheme.colors.subTextDark,
                modifier = Modifier
                    .clickable(onClick = {
                        Log.d("BottomBar", "Нажатие на кнопку оповещения")
                        notificationOnClick()
                    })
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.profile),
                contentDescription = "",
                tint = if (selectedInt == 3) CustomTheme.colors.accent else CustomTheme.colors.subTextDark,
                modifier = Modifier
                    .clickable(onClick = {
                        Log.d("BottomBar", "Нажатие на кнопку профиль")
                        profileOnClick()
                    })
            )

        }
    }
}

@Preview
@Composable
private fun BottomBarPrev() {
    CustomTheme {
        BottomBar(
            selectedInt = 0,
            homeOnClick = { },
            favoriteOnClick = { },
            notificationOnClick = { },
            profileOnClick = { },
            basketOnClick = { }
        )
    }
}