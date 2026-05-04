package com.example.shop.presentation.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun CardButton(modifier: Modifier = Modifier, bitmap: Int) {
    Box(
        modifier = Modifier

            .background(
                CustomTheme.colors.block,
                shape = RoundedCornerShape(16.dp)
            )
            .size(56.dp), contentAlignment = Alignment.Center
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(bitmap),
            contentDescription = "",
            modifier= Modifier.size(width = 45.dp, height = 23.62.dp)
        )
    }
}

@Preview
@Composable
private fun CardButtonPrev() {
    CustomTheme {
        CardButton(bitmap = R.drawable.bot)
    }
}