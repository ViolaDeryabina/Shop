package com.example.shop.presentation.components

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Функция для создания компонента кнопки
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = false,
    icon: @Composable (() -> Unit)? = null,
) {
    logInfo("PrimaryButton","Создание компонента","Кнопка")

    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = ButtonColors(
            containerColor = CustomTheme.colors.accent,
            contentColor = CustomTheme.colors.block,
            disabledContentColor = CustomTheme.colors.block,
            disabledContainerColor = CustomTheme.colors.disable,
        ),
        contentPadding = PaddingValues(start = 15.dp, top = 18.dp, bottom = 16.dp),
        enabled = enabled,
        shape = RoundedCornerShape(13.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            icon?.invoke()
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = text,
                    color = CustomTheme.colors.block,
                    style = CustomTheme.typography.BodyRegular14
                )
            }
        }
    }
}

@Preview(wallpaper = Wallpapers.NONE, device = "id:pixel_4"
)
@Composable
private fun RegisterAccountPrev() {
    CustomTheme {
        PrimaryButton(
            onClick = {},
            text = "В корзину",
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.bag_2),
                    contentDescription = "",
                    tint = CustomTheme.colors.block,
                    modifier = Modifier
                        .size(30.dp)
                )
            },
            enabled = true,
            modifier = Modifier.fillMaxWidth()
        )
    }

}