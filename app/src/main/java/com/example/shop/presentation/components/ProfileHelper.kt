package com.example.shop.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun ProfileHelper(modifier: Modifier = Modifier, icon: Int, title: String) {
    Icon(
        imageVector = ImageVector.vectorResource(icon),
        contentDescription = "",
        modifier = Modifier
            .size(24.dp),
        tint = CustomTheme.colors.block
    )
    Spacer(modifier = Modifier.width(30.dp))
    Text(
        title,
        style = CustomTheme.typography.BodyRegular16,
        color = CustomTheme.colors.block
    )
}

@Preview
@Composable
private fun ProfiltHelperPrev() {
    CustomTheme{
        //ProfileHelper()
    }
}