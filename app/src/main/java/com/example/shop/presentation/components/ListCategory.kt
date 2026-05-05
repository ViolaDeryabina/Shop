package com.example.shop.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.theme.CustomTheme

//Назначение:  Функция для создания компонента для отображения категорий с строки с прокруткой
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun ListCategory(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    list: List<String>
) {
    logInfo("ListCategory","Создание компонента"," Лист категорий")

    LazyRow(modifier=modifier) {
        items(list) { item ->
            SmallButton(text = item, onClick = { onClick() })
            Spacer(modifier= Modifier.width(16.dp   ))
        }
    }
}


@Preview
@Composable
private fun ListCategoryPrev() {
    CustomTheme {
       // ListCategory()
    }
}