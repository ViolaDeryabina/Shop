package com.example.shop.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Функция для создания компонента кнопки
//Автор: Дерябина В.Н.
//Дата: 30.04.2026

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    colors: ButtonColors = ButtonColors(
        containerColor = CustomTheme.colors.block,
        contentColor = CustomTheme.colors.text,
        disabledContentColor = CustomTheme.colors.text,
        disabledContainerColor = CustomTheme.colors.block,
    ),
    shape: Shape = RoundedCornerShape(8.dp),
    colorText: Color = CustomTheme.colors.text,
) {
    logInfo("SmallButton","Создание компонента","Кнопка")

    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = colors,
        contentPadding = PaddingValues(top = 4.dp, bottom = 5.dp),
        shape = shape
    ) {
        Text(
            text = text,
            color = colorText,
            style = CustomTheme.typography.BodyRegular14
        )
    }
}