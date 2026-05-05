package com.example.shop.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.theme.CustomTheme

//Назначение:  Функция для создания компонента для отображения header
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun ScreenHeader(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon:  @Composable (() -> Unit)? = null,
) {
    logInfo("ScreenHeader","Создание компонента","Header")

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier
                .size(44.dp)
                .background(CustomTheme.colors.block, CircleShape),
            onClick = onBackClick
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.direction_left),
                contentDescription = "Back",
                modifier = Modifier.size(14.dp)
            )
        }
        Text(
            text = title,
            style = CustomTheme.typography.BodyRegular16,
            color = CustomTheme.colors.text
        )
        if(icon != null) icon() else  Spacer(modifier = Modifier.size(44.dp))

    }
}

@Preview
@Composable
private fun ScreenHeaderPrev() {
    CustomTheme{
        ScreenHeader(
            title = "title",
            onBackClick = {},
            modifier = Modifier
        )
    }
}