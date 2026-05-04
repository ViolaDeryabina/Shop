package com.example.shop.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание компонента для обработки нажатий
//Автор: Дерябина В.Н.
//Дата: 30.04.2026

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
) {
    Log.i("SmallButton","Создание компонента для обработки нажатий")

    Button(
        onClick = { onClick() },
        modifier = modifier
            .height(40.dp)
            .width(108.dp),
        colors = ButtonColors(
            containerColor = CustomTheme.colors.block,
            contentColor = CustomTheme.colors.text,
            disabledContentColor = CustomTheme.colors.text,
            disabledContainerColor = CustomTheme.colors.block,
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(
            text = text,
            color = CustomTheme.colors.text,
            style = CustomTheme.typography.BodyRegular14
        )
    }
}