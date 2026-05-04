package com.example.shop.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun CustomBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomTheme.colors.block)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(CustomTheme.colors.block),
            horizontalAlignment = horizontalAlignment
        ) {
            content()
        }
    }
}

@Preview
@Composable
private fun CustomBoxPrev() {
    CustomTheme {
        CustomBox(content = {})
    }
}