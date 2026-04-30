package com.example.shop.presentation.components

import androidx.compose.foundation.layout.height
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
fun SecondaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = false
) {
    Button(
        onClick = { onClick() }, modifier = modifier.height(50.dp),
        colors = ButtonColors(
            containerColor = CustomTheme.colors.block,
            contentColor = CustomTheme.colors.text,
            disabledContentColor = CustomTheme.colors.text,
            disabledContainerColor = CustomTheme.colors.block,
        ),
        enabled = enabled,
        shape = RoundedCornerShape(13.dp),
    ) {
        Text(
            text = text,
            color = CustomTheme.colors.text,
            style = CustomTheme.typography.BodyRegular14
        )
    }
}

