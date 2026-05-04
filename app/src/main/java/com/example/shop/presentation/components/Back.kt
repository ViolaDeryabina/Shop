package com.example.shop.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание компонента для перехода на предыдущую страницу
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun Back(modifier: Modifier = Modifier, onClick:()-> Unit, color: Color = CustomTheme.colors.background) {
    Log.i("Back","Создание компонента для перехода на предыдущую страницу")

    Box(
        modifier = Modifier
            .background(color, shape = CircleShape)
            .size(44.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.direction_left),
            contentDescription = "",
            tint = CustomTheme.colors.text,
            modifier = Modifier.clickable(onClick=onClick)
        )
    }
}

@Preview
@Composable
private fun RegisterAccountPrev() {
    CustomTheme {
        Back(onClick = {})
    }

}