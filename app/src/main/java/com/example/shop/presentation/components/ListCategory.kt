package com.example.shop.presentation.components

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
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun ListCategory(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    list: List<String>
) {

    LazyRow(modifier=modifier) {
        items(list) { item ->
            SmallButton(text = item, onClick = { onClick() })
            Spacer(modifier= Modifier.width(16.dp   ))
        }
    }
}

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
) {
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

@Preview
@Composable
private fun ListCategoryPrev() {
    CustomTheme {
       // ListCategory()
    }
}